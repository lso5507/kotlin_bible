package concurrency

import kotlinx.coroutines.*

fun main()= runBlocking<Unit> {
    val job = launch {
        while(this.isActive){
            println("작업중")
            //yield를 하지않는다면 해당 launch의 thread가 종료되지않음
            yield()
        }
    }
    delay(100L)
    //launch의 쓰레드가 가지고 있는 점유권이 yield로 넘어오지않는다면 cancel은 실행될 수 없음 
    job.cancel()
}