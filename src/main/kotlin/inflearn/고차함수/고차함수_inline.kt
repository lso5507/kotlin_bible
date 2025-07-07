package inflearn.고차함수

fun main(){
    repeat(2,{->println("HelloWolrd")})
    iterate(listOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14)){num->
        if(num!=3) println("$num")
    }
}
// inline을 써주지 않으면 exec는 Function 객체로 인스턴스화 됨(사용횟수만큼)
// inline 사용시 exec 함수가 본문에 삽입됨
inline fun repeat(time:Int,exec:()->Unit){
    for(i in 1..time)
        exec()
}

fun iterate(list:List<Int>,calc:(Int)->Unit){
    for(i in list){
        calc(i)
    }
}