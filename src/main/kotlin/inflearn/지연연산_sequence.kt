package inflearn

fun main(){
    val humans = listOf(Male("LSW"), Female("LHH"), Male("KHH"))
    /**
     * 지연연산은 최종연산 전까지는 실제 연산을 수행하지 않는다. (여기서는 forEach)
     * 언제나 iterate 보다 빠른건 아니고 지연연산에서 필요한 오버헤드보다 연산을 진행해야 할 컬렉션 수가 많아진다면 지연연산이 빠름.
     */
    humans.asSequence()
        .filter{it.name.startsWith("L")}
        .map{it.name}
        .take(10_000)
        .forEach(::println)
}

interface Human{
    var name:String
}
class Male(override var name:String):Human
class Female(override var name:String):Human