package basic

fun main(){
    //수정불가
    val a = listOf<Int>(1,2,3)
    //수정가능
    val b = mutableListOf<Int>(1,2,3)
    b.add(1)
    b.add(2)
    println(a)
    println(b)
}