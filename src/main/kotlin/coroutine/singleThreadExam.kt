package coroutine

import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

fun main()= runBlocking<Unit>{
    val dispatcher = newSingleThreadContext(name="singleThread")
    launch(context= dispatcher) {
        println("[${Thread.currentThread().name}] Start")
    }
}