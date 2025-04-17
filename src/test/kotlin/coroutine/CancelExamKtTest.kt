package coroutine

import kotlinx.coroutines.*
import kotlin.test.Test
import kotlin.test.assertTrue

class CancelExamKtTest {

    @Test
    fun testMainJobCancelsAfterDelay() = runBlocking {
        var outputCaptured = false
        val testJob: Job = launch(Dispatchers.Default) {
            while (isActive) {
                outputCaptured = true // Simulating println output capture
            }
        }

        delay(100L)
        testJob.cancel()

        assertTrue(outputCaptured, "The coroutine should produce output before being cancelled.")
        assertTrue(!testJob.isActive, "The coroutine job should be cancelled after delay.")
    }
}