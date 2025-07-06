package inflearn

fun main(){
    val kim = Person().apply { name="kim"}
    val lee = Person().apply { name="lee"}
    kim.takeIf{ it.isKim() }?.toPrint()
    lee.takeIf{ it.isKim() }?.toPrint()

}
class Person{
    lateinit var name:String

    fun isKim()=this.name.startsWith("Kim", ignoreCase = true)
    fun toPrint(){
        println("name: $name")
    }
}