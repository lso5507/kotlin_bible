package async

import kotlinx.coroutines.*

/**
 * withContext는 async await과 다르게 코루틴을 새로 생성하지 않고 메인스레드의 코루틴을 재사용함
 */
fun main() = runBlocking {
    val startTime = System.currentTimeMillis()

    /**
     * participants1, participants2의 withContext는 메인스레드의 코루틴을 공유함
     */
    val participants1 = withContext(Dispatchers.IO){
        println("withContext_${Thread.currentThread().name}")
        delay(1000L)
        return@withContext arrayOf("Lee","Kim")
    }
    val participants2 = withContext(Dispatchers.IO){
        println("withContext_${Thread.currentThread().name}")
        delay(1000L)
        return@withContext arrayOf("Han")
    }
    println("Participants are ${participants1.toList() + participants2.toList()}")
    //delay(1000L) * 2 로 2초이상의 지연시간 발생
    println("Total time taken ${System.currentTimeMillis() - startTime} ms")
}