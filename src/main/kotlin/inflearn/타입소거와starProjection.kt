package inflearn

/**
 * Java 제네릭이 없던 시절에 생성된 List와 제네릭이 있었을 시기에 생성된 List의 호환성을 위해 타입소거가 진행됨
 * List<String> -> List
 */
fun main(){

}

// Kotlin 에서는 starProjection을 통해 해당 data 오브젝트가 List 타입인지 확인할 수 있음

fun checkList(data:Any)= data is List<*>
fun checkList2(data: MutableList<String>) = data is MutableList<String>