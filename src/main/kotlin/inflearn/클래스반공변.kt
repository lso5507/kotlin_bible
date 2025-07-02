package inflearn
fun main(){
    val fishCage= Cage4<Fish>();
    val fishes = listOf(Fish("fish1"),Fish("fish2"))
    val birds = listOf(Bird("bird1"),Bird("bird2"))
    val animals = mutableListOf(Animal("ani"),Animal("ani2"))
    // 공변은 상위타입의 객체에 하위타입 객체를 넣을 수 있는 것
    // 공변인 경우는 get만 가능 (잘못된 하위타입을 넣는 것을 방지하기 위함)
    // 반공변은 하위타입의 객체에 상위타입 객체를 넣을 수 있는 것
    // 반공변인 경우는 put만 가능
    fishCage.put(Fish("fish3"))
    fishCage.putAll(fishes)
//    fishCage.putAll(animals)
//    fishCage.putAll(birds)
}
class Cage4<in T>{
    private val animals: MutableList<T> = mutableListOf()
    fun put(animal: T){
        animals.add(animal)
    }
    fun putAll(cage: List<T>){
        animals.addAll(cage)
    }
}
open class Fruit {
    open fun name() : String {
        return "Fruit"
    }
}

class Apple : Fruit() {
    override fun name() : String {
        return "Apple"
    }
}

class Orange : Fruit() {
    override fun name() : String {
        return "Orange"
    }
}
fun addBasketApple(fruitBasket: MutableList<in Apple>) {
    fruitBasket.add(Apple())
}

fun main2() {
    val appleBasket: MutableList<Apple> = mutableListOf(Apple(), Apple())
    val orangeBasket: MutableList<Orange> = mutableListOf(Orange(), Orange())
    val fruitBasket: MutableList<Fruit> = mutableListOf(Fruit(), Fruit())

    addBasketApple(appleBasket)
    addBasketApple(fruitBasket)
//    addBasketApple(orangeBasket)

}
