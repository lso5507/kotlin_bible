package suspend

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import utils.getElapsedTime

fun main()= runBlocking{
    val startTime = System.currentTimeMillis()
    val result = searchByKeyword("Star")
    println("result::${result.toList()}")
    println("end::${getElapsedTime(startTime)}")
}
suspend fun searchByKeyword(keyword:String):Array<String> = coroutineScope{
    val dbResultsDeferred = async{
        searchFormDB(keyword)
    }
    val serverResultsDeferred = async{
        searchFormServer(keyword)
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
    return@coroutineScope arrayOf(*dbResult,*serverResult)
}
suspend fun searchFormDB(keyword:String):Array<String>{
    delay(1000L);
    return arrayOf("db ${keyword}","db ${keyword}")
}
suspend fun searchFormServer(keyword:String):Array<String>{
    delay(1000L);
    return arrayOf("db ${keyword}","db ${keyword}")
}