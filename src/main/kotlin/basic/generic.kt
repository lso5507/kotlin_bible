package basic

fun main(){
    UsingGeneric(A()).doShout()
    UsingGeneric(B()).doShout()

    funGeneric(A())
    funGeneric(B())
}
// A 클래스 타입에 해당하는 객체만 호출 가능
fun <T:A> funGeneric(t:T){
    t.shout()
}

open class A {
    open fun shout() {
        println("A shout")
    }
}

class B : A() {
    override fun shout() {
        println("B shout")
    }
}
class UsingGeneric<T:A>(val t:T){
    fun doShout(){
        t.shout()
    }
}