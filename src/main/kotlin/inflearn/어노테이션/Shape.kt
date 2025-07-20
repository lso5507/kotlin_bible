package inflearn.어노테이션

import kotlin.reflect.KClass

fun main(){

}
@Shape(text="test",clazz = Hello::class)
@Shape(text="test2",clazz = Hello::class)
class Hello(val name:String){

}
@Target(AnnotationTarget.CLASS)
@Repeatable
annotation class Shape(val text:String, val clazz:KClass<*>){

}