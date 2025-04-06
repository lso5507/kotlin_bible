package coroutine

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main()= runBlocking {
    //Dispatcher.IO -> 해당 코루틴 JobBuilder가 I/O스레드임을 강조하기 위함
    val updateTokenJob = launch(Dispatchers.IO) {
        println("[${Thread.currentThread().name}] updateTokenJob start")
        delay(100L)
        println("[${Thread.currentThread().name}] updateTokenJob end")
    }
    updateTokenJob.join()
    val networkCallJob = launch(Dispatchers.IO) {
        println("[${Thread.currentThread().name}] networkCallJob 요청")
    }
}