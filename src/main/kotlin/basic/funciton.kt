package basic

fun main(){
    println(add(1,2))
}
//일반적인 함수
fun add_(a:Int,b:Int):Int{
    return a+b
}
//단일 표현식 함수
// 반환형 타입이 Int인것을 유추가능
fun add(a:Int,b:Int):Int = a+b