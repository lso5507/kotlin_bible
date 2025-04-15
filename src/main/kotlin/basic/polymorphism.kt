package basic

fun main(){
    val a = Drink()
    a.drink()

    val b : Drink = Cola()
    b.drink()
    if( b is Cola){//if 문 앞에서 일시적 캐스팅
        b.washD()
    }
    //Cola로 캐스팅 된 C, 동시에 b도 캐스팅 됨
    val c = b as Cola
    c.washD()
    b.washD()
}
open class Drink{
    var name="음료"
    open fun drink(){
        println("${name}을 마십니다.")
    }
}
class Cola: Drink() {
    var type = "콜라"
    override fun drink() {
        println("${type}을 마십니다")
    }
    fun washD(){
        println("${type}으로 설거지 합니다")
    }
}