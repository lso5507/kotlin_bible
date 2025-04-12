package exception

import kotlinx.coroutines.*

fun main() = runBlocking<Unit>{
    val exceptionHandler = CoroutineExceptionHandler{coroutineContext, throwable ->
        println("Caught $throwable in CoroutineExceptionHandler")
    }
    val supervisedScope= CoroutineScope(SupervisorJob()+exceptionHandler)
    supervisedScope.apply{
        launch(CoroutineName("myCoroutine1")) {
            throw Exception("Exception in Coroutine 1")
        }
        //myCoroutine1에 의해 종료되지 않음(SupervisorJob 객체이기때문)
        launch(CoroutineName("myCoroutine2")) {
            delay(1000L)
            println("Coroutine 2 finished")
        }
    }
    delay(2000L)
}