package inflearn.고차함수


fun main(){
    Operator.PLUS.calc(1,2).let(::println)
    Operator.MINUS.calc(1,2).let(::println)
    Operator.MULTIPLY.calc(1,2).let(::println)
    Operator.DIVIDE.calc(1,2).let(::println)
    Operator.DIVIDE.calc(0,2).let(::println)
    Operator.DIVIDE.calc(1,0).let(::println)
}
enum class Operator(
    private val operate:Char,
    val calc:(Int,Int)->Any
){
    PLUS('+',{ a, b ->a+b}),
    MINUS('-',{ a, b ->a-b}),
    MULTIPLY('*',{ a, b ->a*b}),
    DIVIDE('%',{ a, b ->
        check(b!=0){"0으로 나눌 수 없습니다."}
        a%b
    }),
}