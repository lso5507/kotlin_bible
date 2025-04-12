package exception

import kotlinx.coroutines.*

fun main(): Unit = runBlocking {
    val superVisorJob = SupervisorJob(parent= this.coroutineContext[Job])
    //superVisorJob으로 설정되어 Exception 전파가 부모 Job까지 전파되지 않음
    launch(CoroutineName("myCoroutine1") + superVisorJob) {
        launch(CoroutineName("myCoroutine3")) {
            throw Exception("Exception in Coroutine 3")
        }
        delay(1000L)
        println("[${Thread.currentThread().name}] Coroutine 1 finished")
    }
    //해당 코루틴은 정상적으로 실행됨
    launch(CoroutineName("myCoroutine2")) {
        delay(1000L)
        println("[${Thread.currentThread().name}] Coroutine 2 finished")
    }
    //complete해주지않으면 Job이 종료되지 않는다
    superVisorJob.complete()
}