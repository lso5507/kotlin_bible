package suspend

import kotlinx.coroutines.*
import utils.getElapsedTime

fun main()= runBlocking{
    val startTime = System.currentTimeMillis()
    val result = searchByKeyword_("Star")
    println("result::${result.toList()}")
    println("end::${getElapsedTime(startTime)}")
}
//searchByKeyword를 superviosrScope로 선언하여 하위 예외가 전파되지 않음
suspend fun searchByKeyword_(keyword:String):Array<String> = supervisorScope{
    val dbResultsDeferred = async{
        searchFormDB_(keyword)
    }
    val serverResultsDeferred = async{
        searchFormServer_(keyword)
    }
    val dbResult =try{
        dbResultsDeferred.await()
    }catch(ex:Exception){
        arrayOf()
    }
    val serverResult =try{
        serverResultsDeferred.await()
    }catch(ex:Exception){
        arrayOf()
    }
    //coroutineScope로 return 되게끔 지정
    // * 는 Collections의 데이터를 스프레드 연산자로 펼쳐낸 것
    return@supervisorScope arrayOf(*dbResult,*serverResult)
}
suspend fun searchFormDB_(keyword:String):Array<String>{
    delay(1000L);
    throw Exception("DB Error");
}
suspend fun searchFormServer_(keyword:String):Array<String>{
    delay(1000L);
    return arrayOf("db ${keyword}","db ${keyword}")
}