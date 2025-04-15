package basic

fun main(){
    //함수를 파라미터로 전달할수 있음
    println(b(::a))
    //람다 함수
    val c:(String)->Unit= { str->println(str)}
    val d = {s:String->println(s)}
    val e = {s:String->s}
    val f = {s:String-> println(s)}
    c("c")
    d("d")
    println(e("e"))
    f("f")
}
fun a(str:String):String{
    return str;
}
//함수를 매개변수로 받을 수 있음(고차함수)
fun b(funs:(String)->String):String{
    return funs("Hello")
}