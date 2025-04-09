package childCorutine

import kotlinx.coroutines.*
import utils.getElapsedTime

fun main() = runBlocking {
    val parentJob = launch(Dispatchers.IO) {
        val startTime = System.currentTimeMillis()
        //db1, db2, db3 이 들어있는 Array를 각각의 코루틴으로 return (여기서는 최대 총 3개의 코루틴이 사용됨)
        val dbResultsDeffered:List<Deferred<String>> = listOf("db1","db2","db3").map{
            async{
                delay(1000L)
                println("[${Thread.currentThread().name}]${it}으로 부터 데이터를 받아왔습니다.")
                return@async "${it} data"
            }
        }
        val dbResults = dbResultsDeffered.awaitAll();
        println("endTime:${getElapsedTime(startTime)}  dbResults: $dbResults")
    }
}