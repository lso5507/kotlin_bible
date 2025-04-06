package coroutine

import kotlinx.coroutines.*

fun main()= runBlocking{
    /**
     * Dispatchers.Default로 지정하면 해당 Job은 MultiThread 환경으로 동작
     * 누락한다면 Main Thread에서 whileJob이 실행되어 whileJob.cancel이 동작하지 않음
     */
    val whileJob: Job = launch(Dispatchers.Default) {
        while(isActive){
            println("[${Thread.currentThread()}}run")
        }
    }
    delay(100L)
    whileJob.cancel()
}