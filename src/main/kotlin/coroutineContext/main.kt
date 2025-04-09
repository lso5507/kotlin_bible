package coroutineContext

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

fun main() = runBlocking {
    val coroutineName = CoroutineName("myCoroutine")
    val coroutineDispatcher = Dispatchers.IO
    val job = Job()
    //CoroutineContext의 각각의 name,job,dispatcher를 설정할때는 + 연산자를 사용
    val coroutineContext: CoroutineContext = coroutineName + coroutineDispatcher + job
    println(coroutineContext)

    val deletedContext = coroutineContext.minusKey(Job)
    println(deletedContext)
}