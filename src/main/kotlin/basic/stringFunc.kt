package basic

fun main(){
    val str = "a.b.c.d"
    println(str.length)

    val spl = str.split('.')
    println(spl)
    println(spl.joinToString())
    println(spl.joinToString("-"))

    println(str.substring(0..2))
    println(str.startsWith("a."))
    println(str.endsWith(".d"))
    println(str.contains("b.c"))

}