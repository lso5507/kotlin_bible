package inflearn

import kotlin.properties.Delegates


class Observable{
    val ageLogs =  mutableListOf<Int>()
    var age:Int by Delegates.observable(20){_, oldValue, newValue ->
        ageLogs.add(oldValue)
        println("oldValue: $oldValue -> newValue: $newValue")
    }
    fun printAgeLogs(){
        println(ageLogs)
    }
}
class Person3{
    var age:Int by Delegates.observable(20){_, oldValue, newValue ->
        println("oldValue: $oldValue -> newValue: $newValue")
    }
    var name:String by Delegates.vetoable("kim"){_, _, newValue ->
         newValue.startsWith("Kim", ignoreCase = true)
    }
    @Deprecated(message = "미사용입니다. gender를 사용햐주세요", replaceWith = ReplaceWith("gender"))
    var sex: String=""
    var gender: String by this::sex

    override fun toString() = "Person3(age=$age, name='$name', sex='${sex}, gender='$gender')"
}
class MappedPerson(map:Map<String,Any>){
    val name: String by map
    val age: Int by map
    override fun toString() = "MappedPerson(name='$name', age=$age)"
}
fun main(){
//    val observable = Observable()
//    observable.age=10
//    observable.age=20
//    observable.printAgeLogs()
    val person3 = Person3().apply{
        age=30
        name="lee"
        sex="Male"
    }
    //name이 kim으로 시작하지않아 변경이 반려 됨
    println(person3)
    //MappedPersion 클래스에서는 Map 클래스로 프로퍼티 위임을 진행하기 때문에 Map데이터에 대한 위임이 가능하다
    MappedPerson(mapOf("name" to "kim", "age" to 30)).let(::println)

}