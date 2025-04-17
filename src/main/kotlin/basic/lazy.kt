package basic

fun main() {
    val num: Int by lazy {
        println("초기화")
        7
    }
    //여기서는 num이 초기화되지않음
    println("start")
    //여기서 초기화 됨
    println(num)
    println(num)
}
