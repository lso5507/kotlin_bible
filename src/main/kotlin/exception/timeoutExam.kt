package exception

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    launch(CoroutineName("childCoroutine")) {
        withTimeout(1000L) { //실행시간을 1초로 제한
            delay(2000L) //2초 delay로 무조건 실패
            println("${Thread.currentThread().name} is running")
        }
    }
    launch(CoroutineName("childCoroutine2")){
        //timeout 시 null 반환
        val result=withTimeoutOrNull(1000L){
            delay(2000L)
            println("${Thread.currentThread().name} is running")
        }
        println("result : $result")

    }
    delay(2000L)
    println("${Thread.currentThread().name} is running")

}