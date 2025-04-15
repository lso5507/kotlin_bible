package basic

interface Runner{
    fun run()
}
interface Eatter{
    //open함수로 간주
    fun eat(){
        println("awd")
    }
}
class Dog_(var age:Int=0):Runner,Eatter{
    override fun run() {
        println("run ")
    }

}
fun main(){
    var dog = Dog_(10)
    dog.eat()
    dog.run()
}