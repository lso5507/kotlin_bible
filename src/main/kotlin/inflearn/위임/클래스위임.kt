package inflearn.위임

interface Fruit{
    val name:String
    val color:String
    fun toPrint() {
        println("name:$name color:$color")
    }
}
class Apple: Fruit{
    override val name:String
        get()="사과"
    override val color: String
        get()="빨강"
}
class GreenApple(apple:Apple): Fruit by apple {
    override val color: String
        get() = "초록"
    //override 안하면 Apple의 toPrint() 함수를 위임받음..
    override fun toPrint() {
        super.toPrint()
    }
}
fun  main(){
    val apple = Apple()
    val greenApple = GreenApple(Apple())
    apple.toPrint()
    greenApple.toPrint()
}