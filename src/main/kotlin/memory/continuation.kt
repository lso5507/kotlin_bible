package memory

import kotlinx.coroutines.CancellableContinuation
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.concurrent.thread

fun main() = runBlocking {
    val result = suspendCancellableCoroutine<String> {continuation: CancellableContinuation<String> ->
        //새로운 스레드 생성
        thread{
            Thread.sleep(1000L)
            //resume deprecated로 resumeWith 사용
            continuation.resumeWith(Result.success("실행결과")) // 코루틴 재개
        }
    }
    println(result)
}