package inflearn.연산자오버로딩

data class Point(val x:Int, val y:Int){
    operator fun unaryMinus() = Point(-x, -y)
    operator fun inc() = Point(x+1, y+1)
}
fun main(){
    var  point = Point(-1, 1)
    println(-point)
    println(++point)
}
