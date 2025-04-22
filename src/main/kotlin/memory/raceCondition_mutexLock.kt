package memory

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import utils.getElapsedTime

var mutexCount = 0

/**
 * Mutex Lock 을 걸어 RaceCondition을 해결
 */
val mutex = Mutex()
fun main()= runBlocking<Unit> {
    val startTime = System.currentTimeMillis()
    withContext(Dispatchers.Default){
        repeat(100000){
            launch {
                /** withLock Scope 내 로직이 종료 전엔 다른 스레드에서 접근 불가
                 *  ReentrantLock 객체를 사용해도 되지만, lock으로 인해 중단된 스레드를 계속 점유하고 있기떄문에 mutex 사용 권장
                 */
                mutex.withLock{
                    mutexCount++

                }
            }
        }
    }
    println("count : $mutexCount")
    println("call Time : ${getElapsedTime(startTime)}")
}