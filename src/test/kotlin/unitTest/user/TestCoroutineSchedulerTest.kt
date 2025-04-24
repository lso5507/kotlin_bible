package unitTest.user

import kotlinx.coroutines.delay
import kotlinx.coroutines.test.currentTime
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TestCoroutineSchedulerTest {
    @Test
    fun `runTest활용`(){
        // given
        var result = 0
        // when
        //runTest 사용시 일시중단 함수를 만나고 무시
        runTest {
            delay(1000L)
            println(this.currentTime)
            result=1
            delay(1000L)
            result=2
        }
        // then
        assertEquals(result, 2)
    }
}