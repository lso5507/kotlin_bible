package exception

import kotlinx.coroutines.*

fun main()= runBlocking<Unit> {
    /**
     * async의 호출부 Exception Handling을 이렇게 잡으면 await 호출부가 없어도
     * Corotuine1의 예외가 Coroutine2까지 전파되므로 SupervisorScope 사용해야함
     */
//    async(CoroutineName("myCoroutine1")) {
//        throw Exception("My Exception")
//    }
    val deferred=supervisorScope {
        async(CoroutineName("myCoroutine1")) {
            throw Exception("My Exception")
        }
        launch(CoroutineName("myCoroutine2")) {
            println("Coroutine 2 completed")
        }
    }



}