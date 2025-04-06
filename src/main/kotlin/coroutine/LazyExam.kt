package coroutine

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun getElapsedTime(startTime:Long):Long{
    val endTime = System.currentTimeMillis()
    return endTime - startTime
}
fun main()=runBlocking<Unit>{
    val startTime = System.currentTimeMillis()
    val lazyJob = launch(start = CoroutineStart.LAZY) {
        println("[${Thread.currentThread().name}] [${getElapsedTime(startTime)}] Start")
    }
    delay(1000L)
    lazyJob.start()
}