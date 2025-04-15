package basic

import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    //c 언어의 goto와 비슷
    awd@for(i in 0..10){
            for(j in 0..10){
                if(i ==0 && j == 3){
                    //label이 달려있는 위치로 이동
                    break@awd
                }
                println("$i, $j")
            }
    }

}
fun foo1() {
    listOf(1, 2, 3, 4, 5).forEach lit@{
        if (it == 3) return@lit // 람다식(forEach loop)에 대한 local return
        print(it)
    }
    print("명시적 label을 사용한 코드")
}

fun foo2() {
    listOf(1, 2, 3, 4, 5).forEach {
        if (it == 3) return@forEach // 람다식(forEach loop)에 대한 local return
        print(it)
    }
    print("묵시적 label을 사용한 코드")
}
fun foo() {
    listOf(1, 2, 3, 4, 5).forEach(fun(value: Int) {
        if (value == 3) return  // 익명함수(forEach loop)에 대한 local return
        print(value)
    })
    print("익명함수를 사용한 코드")
}