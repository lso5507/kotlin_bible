package suspend

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    //fun main은 runBlocking Scope내에 있으므로 suspend없이 delay가 사용가능
    delay(100L)
    delayAndPrint()
    delayAndPrint()

}

/**
 * delay함수는 suspend 함수에서만 사용가능
 */
suspend fun delayAndPrint(){
    delay(1000L)
    println("Hello")
}