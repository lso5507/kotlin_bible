package inflearn

fun main(){
    val mutableListOf = Cage5(mutableListOf(Bulldog(), SibarDog()))
    mutableListOf.printAfterSorting()

    mutableListOf(Bulldog(), SibarDog()).hasIntersection(mutableListOf(Bulldog())).let(::println)
    val bulldog = Bulldog()
    mutableListOf(bulldog, SibarDog()).hasIntersection(mutableListOf(bulldog)).let(::println)

}
fun <T> List<T>.hasIntersection(other:List<T>):Boolean= (this.toSet() intersect other.toSet()).isNotEmpty()
abstract class Dog(
    name:String,
    private val size:Int
):Animal(name), Comparable<Dog>{
    override fun compareTo(other: Dog): Int {
        return this.size.compareTo(other.size)
    }
}
class Bulldog:Dog("불독",100)
class SibarDog:Dog("시바견",500)
class Cage5<T>(
    private val animals: MutableList<T> = mutableListOf()
) where T : Animal, T:Comparable<T>{
    fun printAfterSorting(){
        animals.sorted()
            .map{ it.name}
            .let(::println)
    }
    fun getFirst() = animals.first()
    fun getAll():List<T> = animals.toList()

    fun put(animal: T){
        animals.add(animal)
    }
    fun putAll(cage: Cage5<T>){
        animals.addAll(cage.getAll())
    }
}
