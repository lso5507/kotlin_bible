package basic

/**
 * 코틀린에서 class는 생성자 함수가 따로 팔요없음
 */
class Prs(var name: String = "", var age: Int = 0){
    fun introduce(){
        println("my name is ${name}, and i am ${age} years old.")
    }
}
//상속가능한 클래스는 open 접두어가 들어가야함
open class Animal(var name: String = "", var age: Int = 0, type:String){
    //위에 type은 val,var으로 선언되어있지 않으므로 클래스 내부에서만 사용할수 있는 변수
    private val privateType:String = type
    // 자식 클래스에서 사용하려면 open 필수
    open fun introduce(){
        println("my name is ${this.name}, and i am ${this.age} years old. type ${this.privateType}")
    }
}
class Dog(var dogName: String = "", var dogAge: Int = 0):Animal(dogName, dogAge,"Dog"){
    fun dogIntroduce(){
        println("Dog's name is ${dogName}, and i am ${dogAge} years old.")
    }
    override fun introduce(){
        super.introduce()
        dogIntroduce()
    }

}
fun main(){
    var prs = Prs("john", 20)
    prs.introduce()
    var dog = Dog("john", 20)
    dog.introduce()
    var animal = Animal("animal", 20,"animal")
    animal.introduce()
}
