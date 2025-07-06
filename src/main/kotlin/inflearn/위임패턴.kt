package inflearn

import kotlin.reflect.KProperty

fun main(){
//    println(Person2().name)
    val person2 = Person2();
    person2.apply{age=11}.let(::println)
}

class Person2{
    private val delegateProperty= LazyInitProperty {
        Thread.sleep(1000)
        "홍길동"
    }
    val name: String
        get()= delegateProperty.value
    //var 변수이므로 getValue,setValue 둘다 필요함
    var age:Int by LazyInitProperty{10}
    //val 변수이므로 setValue 없음
    val gender:String by lazy{
        "M"
    }

    override fun toString() = "Person2(name='$name', age=$age)"
}

class LazyInitProperty<T>(val init:()->T){
    private var _value:T? =null
    val value : T
        get(){
            if(_value==null){
                _value = init()
            }
            return _value!!
        }
    operator fun getValue(thisRef: Any, property: KProperty<*>):T{
        println("getValue")
        return value
    }
    operator fun setValue(thisRef: Any, property: KProperty<*>, value: T){
        println("setValue")
        this._value = value
    }

}