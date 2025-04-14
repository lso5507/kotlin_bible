package basic

fun main(){
    var a =7;
    //일반적인 if 조건문
    if(a>6)
        println("a는 6보다 큽니다.")
    if(a is Int){
        println("a는 정수형입니다.")
    }
    exWhen(a)
}
//switch 문 과 비슷
fun exWhen(a:Any){
    when(a){
        5->println("a는 5입니다.")
        "awd"->println("a는 awd입니다")
        else -> println(a)
    }
}
//이런식으로 b에 대입가능
fun exWhen_(a:Any){
    var b=
        when(a){
            5->a
            "awd"->a
            else -> a
        }
    println(b)
}