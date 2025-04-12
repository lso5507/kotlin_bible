package exception

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Exception이 runBlocking 객체로 전파되어 실제 handler가 동작하지 않음
 */
fun main()= runBlocking<Unit> {
    val exceptionHandler = CoroutineExceptionHandler{
        coroutineContext, throwable ->
        println("Exception handled: ${throwable.localizedMessage}")
    }
    launch(CoroutineName("name1") +exceptionHandler){
        throw Exception("My Exception")
    }
}