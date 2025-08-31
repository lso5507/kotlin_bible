package inflearn


fun main(){
    runCatching {
        todoCall()
    }.onFailure {
        println(it.message)
    }.onSuccess {
        println("success")
    }
}
fun todoCall(){
    TODO("코틀린 에서는 TODO 주석대신 이렇게 처리가능 해당 TODO 함수가 호출되면 NotImplementedError 발생")

}
fun require(num:Int){
    require(num>0){"0보다 커야합니다."}
}
fun check(num:Int){
    check(num>0){"0보다 커야합니다."}
}