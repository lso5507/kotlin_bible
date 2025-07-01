package inflearn


fun main() {
    val fish = Fish("fish");
    val goldFish = GoldFish("goldFish");
    val cage = Cage2<Fish>()
    val cageGoldFish = Cage2<GoldFish>()
    val cageAny = Cage2<Any>()
    cage.put(fish)
    cage.put(goldFish)
    cageGoldFish.put(goldFish)

    cage.moveFrom(cageGoldFish)

    // 반공변 예제 시연
    cage.copyTo(cageAny)
}
open class Animal(val name:String)
open class Fish(name: String):Animal(name)
open class Bird(name: String):Animal(name)
class GoldFish(name: String) : Fish(name)

/**
 * 자바코드를 예로들자면.
 * String[] strs = new String[]{"A","B"};
 * Object[] objs = strs; -> 배열은 공변하기 때문에 가능합니다.
 * objs[0] = 1;
 *  해당 코드는 컴파일떄는 통과되며, 런타임 때 ArrayException이 발생합니다.
 */
class Cage2<T> {
    private val animals: MutableList<T> = mutableListOf()
    fun getFirst(): T {
        return animals.first()
    }

    fun put(animal: T) {
        animals.add(animal)
    }

    //List는 배열과 다르게 무공변하므로 List<Fish>와 List<GoldFish>는 상속관계를 띄지않음
//    fun moveFrom(cage:Cage2<T>){
//        this.animals.addAll(cage.animals)
//    }
    //Cage2 클래스에 공변을 줌
    //공변을 준다면 데이터를 조회만 가능
    fun moveFrom(cage: Cage2<out T>) {
        this.animals.addAll(cage.animals)
    }

    // 반공변 예제
    fun copyTo(cage: Cage2<in T>) {
        cage.animals.addAll(this.animals)
    }
}
