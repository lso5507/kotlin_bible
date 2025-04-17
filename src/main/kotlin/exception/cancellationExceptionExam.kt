package exception

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    launch(CoroutineName("myCoroutine1")) {
        launch(CoroutineName("myCoroutine2")) {
            //해당 Exception은 myCoroutine1의 로직에 영향이 가지않음(부모 코루틴으로 전파X)
            throw CancellationException("Coroutine 2 is cancelled")
        }
        delay(1000L)
        println("[${Thread.currentThread().name}] Start")
    }
}