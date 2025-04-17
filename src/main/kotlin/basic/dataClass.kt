package basic

/**
 * 클래스에 has(), equals(), toString(), copy(), componentX()을 자동으로 구현해주는 클래스
 *
 */
fun main() {
    val va = notDataClassA("a", 123)

    println(va == notDataClassA("a", 123))
    println(va)

    val vb = dataClassB("a", 123)

    println(vb == dataClassB("a", 123))
    println(vb)

    //복사
    println(vb.copy())
    println(vb.copy(name = "b"))
    println(vb.copy(id = 234))

    val list = listOf<dataClassB>(
        dataClassB("a", 123),
        dataClassB("b", 234),
        dataClassB("c", 345)
    )
    //자동으로 변수의 위치를 판별해 a, b에 값을 넣어준다
    for ((a, b) in list) {
        println("$a $b")
    }
}

class notDataClassA(val name: String, val id: Int)
data class dataClassB(val name: String, val id: Int)