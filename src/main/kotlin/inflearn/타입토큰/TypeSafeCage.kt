package inflearn.타입토큰

import inflearn.Animal
import inflearn.Bird
import inflearn.Carp
import inflearn.GoldFish
import kotlin.reflect.KClass
import kotlin.reflect.KType
import kotlin.reflect.cast


fun main(){
//    val typeSafeCage = TypeSafeCage()
//    typeSafeCage.putOne(GoldFish("붕어대가리"))
//
//    typeSafeCage.getOne<GoldFish>().let(::println)
//    typeSafeCage.getOne<Bird>().let(::println)
    val superTypeToken_ = object:SuperTypeToken<List<GoldFish>>(){}
    val superTypeToken2 = object:SuperTypeToken<List<Bird>>(){}
//    println(superTypeToken.type == superTypeToken2.type)
//    println(superTypeToken.type == superTypeToken_.type)
    val superTypeToken = object:SuperTypeToken<List<GoldFish>>(){}
    val superTypeSafeCage = SuperTypeSafeCage();
    superTypeSafeCage.putOne(superTypeToken,listOf(GoldFish("금붕어1"),Carp("새")))
    superTypeSafeCage.getOne(superTypeToken).forEach(::println)
}
class TypeSafeCage {
    private val animals: MutableMap<KClass<*>,Animal> = mutableMapOf()
    fun <T:Animal>getOne(type:KClass<T>):T{
        return type.cast(animals[type])
    }
    fun <T:Animal>putOne(type:KClass<T>,animal:T){
        animals[type] = type.cast(animal)
    }
    inline fun<reified T:Animal>getOne():T{
        return this.getOne(T::class)
    }
    inline fun<reified T:Animal>putOne(animal: T){
        this.putOne(T::class,animal)
    }
}
class SuperTypeSafeCage {
    private val animals: MutableMap<SuperTypeToken<*>,Any> = mutableMapOf()
    fun <T:Any>getOne(token: SuperTypeToken<T>):T{
        return this.animals[token] as T
    }
    fun <T:Any>putOne(type:SuperTypeToken<*>,animal:T){
        animals[type] = animal
    }
}
abstract class SuperTypeToken<T>{
    val type: KType = this::class.supertypes[0].arguments[0].type!!

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }
    override fun hashCode(): Int {
        return super.hashCode()
    }
}