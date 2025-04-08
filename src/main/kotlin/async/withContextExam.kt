package async

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import utils.getElapsedTime

fun main()= runBlocking{
    /**
     * withContext는 정의와 동시에 해당 scope의 기능 수행을 기다림
     */
    val startTime = System.currentTimeMillis()
    val result = withContext(Dispatchers.IO){
        delay(1000L)
        return@withContext "Result"
    }
    //그래서 해당 출력문이 delay(1000L)후에 수행됨
    println("call ${getElapsedTime(startTime)} ms")
    println(result)
}