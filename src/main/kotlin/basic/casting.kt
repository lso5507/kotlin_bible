package basic


/**
 * 명시적 형변환
 * 암시적 형변환은 코틀린 지원 X
 *  to변수()를 통해 사용
 */
fun main(){
    var a:Int =123
    var b:String = a.toString()
    
    var a_:String = "123"
    var b_:Int = a_.toInt()
}