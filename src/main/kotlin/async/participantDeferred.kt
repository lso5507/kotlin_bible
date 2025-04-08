package async

import kotlinx.coroutines.*

/**
 * participantDeferred, participantDeferred2는 각 1초씩 걸린다고 가정
 * 두개의 async 함수는 await()이 호출되기 전에 이미 수행 됨 (그러므로 딜레이시간이 2초가 넘지않음)
 * 만약 participantDeferred2는 async 함수를 호출하기전 participantDeferred.await()을 수행한다면
 * **2초 이상**ㅌ의 딜레이가 발생하므로 유의해야함
 */
fun main()= runBlocking{
    val startTime = System.currentTimeMillis()
    val participantDeferred = async(Dispatchers.IO){
        delay(1000L)
        return@async arrayOf("Lee","Kim")
    }
    val participantDeferred2 = async(Dispatchers.IO){
        delay(1000L)
        return@async arrayOf("Han")
    }
    val participants1 = participantDeferred.await();
    val participants2 = participantDeferred2.await();
    //또는 awaitAll 사용
    val participants = awaitAll(participantDeferred,participantDeferred2)
    //participants[0] 라는 List 형태의 element들을 꺼내기 위해 스프레드 연산자(*)를 사용
    // -> ["Lee","Kim"] Array 내부의 Element들을 하나씩 펼쳐놓는 형태가 됨. listOf("Lee","Kim","Han")
    println("Participants(awaitAll) are [${listOf(*participants[0],*participants[1])}]")
    println("Participants are ${participants1.toList() + participants2.toList()}")
    println("Total time taken ${System.currentTimeMillis() - startTime} ms")

}