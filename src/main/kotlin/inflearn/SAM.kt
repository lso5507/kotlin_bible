package inflearn

fun interface StringFilter{
    fun predicate(string: String): Boolean
}

fun main(){
    // 파라미터로 SAM 생성자 넘기기 가능
    consumeFilter({s:String->s.startsWith("s")})
}
fun consumeFilter(filter: StringFilter){}