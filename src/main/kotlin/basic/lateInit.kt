package basic

fun main() {
    var t = lateInitExam()
    println(t.test())
    t.a = "zxc"
    println(t.test())
    t.bTest()
}

class lateInitExam {
    lateinit var a: String
    var b:String = "bTest"
    fun test(): String {
        //a가 초기화 됬는지 체크
        // ::은 프로퍼티 참조를 의미 lateInitExam 클래스의 a 프로퍼티를 참조한다는 의미
        if(::a.isInitialized) {
            return a
        }
        else{
            return "null"
        }

    }
    fun bTest():Unit{
        //b의 value 값
        println(b)
        //b의 참조값
        println(::b)
    }
}