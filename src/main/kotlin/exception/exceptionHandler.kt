package exception

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        println("Exception handled: ${throwable.localizedMessage}")
    }
    CoroutineScope(exceptionHandler).launch{
        println("Throwing exception from job")
    }
}