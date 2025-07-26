package inflearn.reflections

import org.reflections.Reflections
import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.KParameter

class DI
object DIContainerV1{
    private val registeredClasses = mutableListOf<KClass<*>>();
    fun register(clazz: KClass<*>){
        registeredClasses.add(clazz)
    }
    fun <T:Any>getInstance(type:KClass<T>) :T{
        return registeredClasses.firstOrNull{clazz->clazz==type}
            ?.let{
                clazz->clazz.constructors.first().call() as T
            }?:throw IllegalArgumentException("해당 인스턴스 타입을 찾을 수 없습니다.")
    }

}
object DIContainerV2{
    private val registeredClasses = mutableListOf<KClass<*>>()
    private val cachedInstances = mutableMapOf<KClass<*>, Any>()
    fun register(clazz: KClass<*>){
        registeredClasses.add(clazz)
    }
    fun <T:Any>getInstance(type:KClass<T>) :T{
        if( type in cachedInstances){
            return cachedInstances[type] as T
        }
        return registeredClasses.firstOrNull{clazz->clazz==type}
            ?.let{
                    clazz->instantiate(clazz) as T
            }?:throw IllegalArgumentException("해당 인스턴스 타입을 찾을 수 없습니다.")
            .also{cachedInstances[type]=it}
    }
    fun <T:Any>instantiate(clazz: KClass<T>):T{
        val constructor = findUsableConstructor(clazz)
        val params=constructor.parameters.map{
            param->getInstance(param.type.classifier as KClass<*>)
        }.toTypedArray()
        return constructor.call(*params)

    }
    fun <T:Any>findUsableConstructor(clazz: KClass<T>): KFunction<T> {
        return clazz.constructors.firstOrNull{
            constructor-> constructor.parameters.isAlRegistered
        }?:throw IllegalArgumentException("사용할 수 있는 생성자가 없습니다.")
    }
    private val List<KParameter>.isAlRegistered: Boolean
        get() = this.all { it.type.classifier in registeredClasses }


}
fun start(clazz:KClass<*>){
    val reflections = Reflections(clazz.packageName)
    reflections.getTypesAnnotatedWith(MyService::class.java)
        .forEach{clazz->
            DIContainerV2.register(clazz.kotlin)
        }

}
private val KClass<*>.packageName:String
    get(){
        val qualifiedNames  = this.qualifiedName?:throw IllegalArgumentException("익명객체입니다.")
        return qualifiedNames.split(".").let{
            it.subList(0,it.size-1).joinToString(".")
        }
    }
fun main(){
//    DIContainerV1.register(AService::class)
//    DIContainerV1.getInstance(AService::class).print()
//    DIContainerV2.register(AService::class)
//    DIContainerV2.register(BService::class)
//    DIContainerV2.register(CService::class)
//    val instance = DIContainerV2.getInstance(BService::class)
//    instance.print()
//    instance.printInstance()
    start(DI::class);
    DIContainerV2.getInstance(BService::class).printInstance()
}
annotation class MyService
@MyService
class AService{
    fun print() = println("AService")
}
@MyService
class BService(
    val aService: AService,
    val cService: CService?
){
    constructor(aService: AService):this(aService,null)
    fun print() = aService.print()
    fun printInstance(){
        println(this)
        println(aService)
        println(cService)
    }
}
class CService()