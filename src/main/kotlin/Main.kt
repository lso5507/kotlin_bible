import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    println("${Thread.currentThread().name} is Running")
    launch(context = CoroutineName("myCoroutine")) {
        println("${Thread.currentThread().name} is Running")
    }
    launch(context = CoroutineName("myCoroutine2")) {
        println("${Thread.currentThread().name} is Running")
}
}