package coroutine

import kotlinx.coroutines.*

fun main()= runBlocking {
//    joinExam()
    joinAllExam()
}

fun joinExam() = runBlocking {
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
fun joinAllExam() = runBlocking {
    val convertImgJob1 = launch(Dispatchers.IO) {
        println("[${Thread.currentThread().name}] converImgJob start")
        delay(100L)
        println("[${Thread.currentThread().name}] converImgJob end")
    }
    val convertImgJob2 = launch(Dispatchers.IO) {
        println("[${Thread.currentThread().name}] converImgJob start")
        delay(100L)
        println("[${Thread.currentThread().name}] converImgJob end")
    }
    /**
     * public suspend fun joinAll(vararg jobs: Job): Unit = jobs.forEach { it.join() }
     */
    joinAll(convertImgJob1, convertImgJob2)
    val updateImgJob = launch(Dispatchers.IO) {
        println("upload image complete")
    }
}