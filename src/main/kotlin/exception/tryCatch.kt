package exception

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit>{
    launch(CoroutineName("myCoroutine")){
        try{
            throw Exception("My Exception")
        }catch (e: Exception){
            println("Exception handled: ${e.localizedMessage}")
        }

    }
    launch(CoroutineName("myCoroutine2")) {
        delay(100)
        println("Coroutine 2 completed")
    }

}