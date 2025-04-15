package basic

class Book(var name: String, var price: Int) {
    fun dc() {
        price -= 2000
    }

    fun printName() {
        println("$name $price")
    }
}

fun main(){
    val book = Book("book1",10000)
    book.apply{
        name = "apply a ${name}"
        dc()
        printName()
    }
    //apply 기능과 동일하나 마지막 로직 return
    val b = book.run{
        name = "run a ${name}"
        dc()
        "returnBook"
    }
    println(b)
    // run 기능과 동일하나 사용법만 다름
    val b_=with(book){
        name = "with a ${name}"
        dc()
        "returnBook"

    }
    println(b_)
    /**
     * 여기서 price 값은 5000으로 출력됨. let 함수 내 it 지정자 필요
     */
//    fun main() {
//        var price = 5000
//        var a = Book("a", 20000)
//        a.run{
//            //20000원이 출력되야하지만 main문의 price가 스코프 우선순위가 높아 5000원 출력
//            println(price)
//        }
//
//    }
//
//    class Book(var name: String, var price: Int) {
//
//    }
    book.let{
        println(it.name)
    }
}