package main.java.parallel

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.Future

/**
 * future 작업종료때 까지 main Thread 또한 쓰레드 블로킹 상태가 유지됨.
 */
fun FutureExam() {
    // thread pool == 2
    val executorService: ExecutorService= Executors.newFixedThreadPool(2)
    val future: Future<String> = executorService.submit<String> {
        println("run task")
        Thread.sleep(2000)
        return@submit "작업1완료"
    }
    val result= future.get()
    println(result)
    //future 객체의 값을 기다린 후 main thread is Running 출력함
    println("main thread is running")
    executorService.shutdown()
}
fun main(){
    FutureExam()
}