package coroutine

import kotlinx.coroutines.launch
import kotlinx.coroutines.newFixedThreadPoolContext
import kotlinx.coroutines.runBlocking

fun main()= runBlocking<Unit>{
    val multiThreadDispatcher = newFixedThreadPoolContext(2, "multiThread")
    //context 옵션으로 생성된 multiThread로 해당 println이 실행될수 있음
    launch(context = multiThreadDispatcher) {
        println("[${Thread.currentThread().name}] Start")
    }
    launch(context = multiThreadDispatcher) {
        println("[${Thread.currentThread().name}] start")
    }
}