package inflearn

fun main(){
    "STR".toSuperString()

    println(listOf(1,2,3).hasAnyInstanceOf<Int>())
    listOf(1,2,3).hasAnyInstanceOf<String>().let(::println)
    // filterIsInstance도 inline과 reified를 사용함
    listOf(1,2,3.3f).filterIsInstance<Float>().let(::println)
}
// inline 과 reified를 사용하면 런타임 시점에도 제네릭 타입을 알 수 있음
// inline은 해당 함수의 내용을 호출부에 그대로 넣는 방식으로 컴파일 코드를 작성
inline fun <reified T> T.toSuperString(){
    println("${T::class.java.name}::$this")
}
inline  fun<reified T>List<*>.hasAnyInstanceOf():Boolean{
    return this.any{it is T}
}