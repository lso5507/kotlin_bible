package inflearn.어노테이션

import kotlin.reflect.KFunction
import kotlin.reflect.KType
import kotlin.reflect.cast
import kotlin.reflect.full.createInstance
import kotlin.reflect.full.createType
import kotlin.reflect.full.hasAnnotation

@Target(AnnotationTarget.CLASS)
annotation class Executable

@Executable
class Reflection{
    fun a(){
        println("A입니다")
    }
    fun b(n:Int){
        println("B입니다 ${n}")
    }
}
fun executeAll(obj:Any){
    val kClass = obj::class
    if(!kClass.hasAnnotation<Executable>()){
        return
    }
    val callableFunctions = kClass.members.filterIsInstance<KFunction<*>>()
        .filter { it.returnType == Unit::class.createType() }
        .filter { it.parameters.size == 2 && it.parameters[0].type == kClass.createType()  && it.parameters[1].type == Int::class.createType()}
    callableFunctions.forEach{
        function -> function.call(obj,1)
    }
}
fun main(){
    executeAll(Reflection())

    val kType :KType= GoldFish::class.createType()
//    val goldFish = GoldFish("금붕이")
//    goldFish::class.members.first { it.name == "print" }.call(goldFish)
}
class GoldFish(val name: String){
    fun print(){
        println("금붕어 이름은 ${name}입니다.")
    }
}

fun castToGoldFish(obj:Any):GoldFish{
    return GoldFish::class.cast(obj)
}