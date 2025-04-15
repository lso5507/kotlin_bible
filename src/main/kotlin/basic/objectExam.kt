package basic

import kotlinx.coroutines.runBlocking

fun main() {
    Counter.increment()
    println(Counter.count)
    Counter.clear()
    println(Counter.count)

    var food=Food()
    food.up()
    println("total ${Food.total}")
    food.delay().also {
        println("also ${Food.total}")
    }
}

/**
 * 싱글톤 패턴
 */
object Counter {
    var count = 0
    fun increment(){
        count++
    }
    fun clear(){
        count = 0
    }
}
class Food(){
    companion object{
        var total = 0
    }
    fun up(){
        total++
    }
    fun delay(){
        Thread.sleep(1000L)
        total++;
    }
}