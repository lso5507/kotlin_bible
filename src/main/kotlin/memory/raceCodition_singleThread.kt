package memory

import kotlinx.coroutines.*

var singleThreadCount = 0
val singleThread = newSingleThreadContext("singleThread")
fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()
    withContext(Dispatchers.Default){
        repeat(100000){
            increaseCount()
        }
    }
    println("count : $singleThreadCount")
    println("call Time : ${System.currentTimeMillis() - startTime}")
}
suspend fun increaseCount()= coroutineScope {
    withContext(singleThread){
        singleThreadCount++
    }
}