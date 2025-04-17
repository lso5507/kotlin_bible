package basic

fun main() {
    var a = St.A
    println(a)
    println(a.msg)

    println(a.isA())
}

enum class St(val msg: String){
    A("a"),
    B("b"),
    C("c");

    fun isA() = this == St.A
}