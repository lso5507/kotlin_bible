package basic

fun main(){
    //일반적인 배열 생성
    var intArr:Array<Int> = arrayOf(1,2,3)
    // nullable
    var intArr2 = arrayOfNulls<Int>(5)
    // any 는 데이터 타입의 최상위(Java의 Object느낌)
    var anyArr:Array<Any> = arrayOf(1,2,3,"Hello")
    println(intArr2)
}