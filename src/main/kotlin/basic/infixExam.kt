package basic

fun main() {
    println("awd" strSum 1)
    println("awd".strSum(2))

    println(3 mul 4)
    println(3.mul(4))
    val test = StrSumClass()
    //strSum_ 함수는 StrSumClass 내 멤버 함수이므로, 해당 컨텍스트 내에서만 사용가능. 그러므로 with절 사용
    with(test){
        println("awd" strSum_ 1)
    }
    println(test strSum__ 1)
}

//infix fun (this에 해당되는 타입).함수이름(인자이름: 타입): 반환 = 구문
infix fun String.strSum(x: Int): String = this + x
infix fun Int.mul(x: Int): Int = this * x

class StrSumClass{
    infix fun String.strSum_(x: Int): String = this + x
    //클래스 사용 시 보통 왼쪽은 클래스 본인이므로 이렇게 사용하는것이 더 올바름
    infix fun strSum__(x: Int): String = "strSum__" + x
}