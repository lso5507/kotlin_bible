package main.java.parallel
import utils.getElapsedTime
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executors

fun completableFuture() {
    val startTime = System.currentTimeMillis()
    val executor = Executors.newFixedThreadPool(2)

    /**
     * @Param
     * Supplier<U>
     * executor
     */
    val completableFuture = CompletableFuture.supplyAsync({
        Thread.sleep(1000)
        //supllyAync 함수로 return 하는 것을 명시함
        return@supplyAsync "Hello"
    }, executor)
    completableFuture.thenAccept{result->
        println("[${getElapsedTime(startTime)}] result : $result")
    }
    //CompletableFuture 결과 값을 기다리지않고 해당 string 출력
    println("[${getElapsedTime(startTime)}] 다른작업 실행")
    executor.shutdown()
}
fun main(){
    completableFuture()
}

