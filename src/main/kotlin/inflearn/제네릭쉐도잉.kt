package inflearn
typealias FishList=   List<Map<Number,Fish>>

fun main(){
    val cageV2 = CageV2<GoldFish>()
    val goldfishCageV2 = GoldfishCageV2()

//    val list:List<Map<Number,Fish>> = mutableListOf<Map<Number,Fish>>()
    // typealias를 이용하여 해당 변수의 타입을 별칭으로 지정할수있음
    val list:FishList = mutableListOf()
}

open class CageV1<T:Animal>{
    open fun addAnimal(animal: T){}
}
// 상속할때 동일하게 제네릭 타입으로 지정
class CageV2<T: Animal>:CageV1<T>(){
    override fun addAnimal(animal: T) {}
}
// 상속할때 아예 특정 클래스 타입으로 지정
class GoldfishCageV2:CageV1<GoldFish>(){
    override fun addAnimal(animal: GoldFish) {
        super.addAnimal(animal)
    }
}