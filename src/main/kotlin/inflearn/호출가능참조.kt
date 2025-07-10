package inflearn


fun add(a:Int,b:Int) = a+b
fun main(){
    // add 함수를 변수에 저장
    // 호출가능 참조를 변수에 저장시 add1은 add의 리플렉션 객체임
    val add1 = ::add
    add1(1,2).let(::println)

}