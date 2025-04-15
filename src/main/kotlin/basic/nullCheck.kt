package basic

fun main(){
    val a =listOf<String?>("awd",null,"zxc")
    val c = mutableListOf<String>()
    val e = mutableListOf<String>()
    val f = mutableListOf<String>()

    for(ele in a){
        //ele 가 null이면 let 구문을 실행하지 않는다
        ele?.let{
            c.add(it)
        }
        //ele가 null이면 default값이 대신 추가됨
        e.add(ele?:"default")
    }
    println(c)
    println(e)

    for(ele in a){
        //b가 null인것을 의도적으로 방치 -> 오류 발생
        f.add(ele!!)
    }
    println(f)
}