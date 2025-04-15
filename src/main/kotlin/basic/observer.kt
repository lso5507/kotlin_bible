package basic

interface EventListener{
    fun onEvent(count:Int)
}
class ObserverCounter(var listener:EventListener){
    fun count(){
        for(i in 0..20){
            if(i%5 == 0 ){
                listener.onEvent(i)
            }
        }
    }
}

class EventPinter:EventListener{
    override fun onEvent(count: Int) {
        println("Event $count")
    }
    fun start(){
        //ObserverCounter에 EventPrinter 클래스르를 넘겨줌
        var count = ObserverCounter(this)
        count.count()
    }
}
class EventPinter_:EventListener{
    override fun onEvent(count: Int) {
        println("Event $count")
    }
    fun start(){
        //ObserverCounter에 EventPrinter 클래스르를 넘겨줌
        //익명 클래스로 넘겨줌
        ObserverCounter(object:EventListener{
            override fun onEvent(count: Int) {
                println("Event $count")
            }
        }).count()
    }
}
fun main(){
    EventPinter().start()
}