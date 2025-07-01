package inflearn

fun main(){
    val fishCage = Cage3<Fish>()
    // Cage3은 공변이므로 상위 클래스에 하윜 클래스를 넣을 수 있음
    val animalCage: Cage3<Animal> = fishCage
}
class Cage3<out T> {
    private val animals: MutableList<T> = mutableListOf()
    fun getFirst() = animals.first()
    fun getAll():List<T> = animals.toList()

}