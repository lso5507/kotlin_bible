package memory

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

// @Volatile로 각 스레드 별 cpu 캐시 메모리 접근을 해결하였지만 메인메모리 동시접근에 대한 문제점은 해결하지 못함 (Race Condition)
var count = 0;
var notVolatileCount = 0;
fun main()= runBlocking<Unit> {
    withContext(Dispatchers.Default){
        repeat(10000){
            launch {
                count++
                notVolatileCount++
            }
        }
    }
    println("count : $count, notVolatileCount : $notVolatileCount")
}