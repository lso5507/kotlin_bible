package childCorutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
    val coroutineScope = CustomCoroutineScope()// 인스턴스화
    coroutineScope.launch {
        delay(1000L)
        println("[${Thread.currentThread().name}] Hello]")
    }
    Thread.sleep(2000L)
}