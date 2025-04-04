package main.java.parallel

class ExampleThread:Thread(){
    override fun run(){
        println("[${Thread.currentThread().name}] is Running")
        Thread.sleep(1000)
        println("[${Thread.currentThread().name}] is Finishing")
    }

}