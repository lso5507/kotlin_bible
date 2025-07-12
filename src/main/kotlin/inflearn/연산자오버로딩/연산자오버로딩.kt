package inflearn.연산자오버로딩

data class Point(val x:Int, val y:Int){
    operator fun unaryMinus() = Point(-x, -y)
    operator fun inc() = Point(x+1, y+1)
}
data class Calculate(val x:Int, val y:Int){
    // 자체적으로 invoke 함수를 override 하면 해당 클래스 생성자 호출시에 invoke 함수가 호출됨
    operator fun invoke() =x+y;
}
fun main(){
    var  point = Point(-1, 1)
    println(-point)
    println(++point)

    val calculate = Calculate(1,2)
    println(calculate())
}
