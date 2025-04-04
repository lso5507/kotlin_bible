package main.java.parallel
fun main() {
    println("${Thread.currentThread().name} is Running")
    ExampleThread().start()
    println("${Thread.currentThread().name} is Finishing")
}