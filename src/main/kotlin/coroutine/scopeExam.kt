package coroutine

import kotlinx.coroutines.*

/**
 * coroutine Scope 학습
 * 코루틴 빌더 람다식은 수신객체를 CoroutineScope 객체를 가짐
 * 그러므로 코루틴 빌더 내부에서 this.launch의 로직이 수행 가능함
 */
fun main() = runBlocking<Unit> {
    launch(CoroutineName("cou1")) {
        //여기서 launch는 this.launch와 동일
        //코루틴 객체는 동일하지 않음
        launch(CoroutineName("cou3")) {
            println("[${Thread.currentThread().name}] 실행]")
        }
        launch(CoroutineName("cou4")) {
            println("[${Thread.currentThread().name}] 실행]")
        }
    }
    launch(CoroutineName("cou2")) {
        println("[${Thread.currentThread().name}] 실행]")
    }
}

/**
 * newScope의 Job과, main launch의 job은 다름
 */
fun newScope() = runBlocking<Unit> {
    launch {
        println("[${Thread.currentThread().name}] Start")
    }
    val newScope= CoroutineScope(Dispatchers.IO);
    newScope.launch {
        println("[${Thread.currentThread().name}] Start")
    }
}