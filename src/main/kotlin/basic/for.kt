package basic

fun main(){
    //일반적인 for문
    for(i in 1..10){
        println(i)
    }
    println()
    // 감소 for문
    for(i in 10 downTo 1){
        println(i)
    }
    println()
    //+2 for문
    for(i in 1..10 step 2){
        println(i)
    }
    println()
    //영어 for문
    for(i in 'a'..'e'){
        println(i)
    }

}