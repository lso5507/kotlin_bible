package basic

fun main() {
    var a: MutableMap<Int, String> = mutableMapOf()
    //javaScript에서 다루는 JsonObject와 비슷해보임
    // a(JsonObject)객체[key] = 'value'
    a[1] = "a"
    a[2] = "b"

    for(i in a){
        println("${i.key} ${i.value}")
    }
    a.remove(1)

    println(a)
    println(a[2])
}