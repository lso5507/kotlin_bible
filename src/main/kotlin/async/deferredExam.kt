package async

import kotlinx.coroutines.*


fun main() = runBlocking{
    val networkDeferred:Deferred<String> = async(Dispatchers.IO){
        delay(1000L)
        return@async "Network Response"
    }
    // await 
    val result= networkDeferred.await()
    println(result)
}