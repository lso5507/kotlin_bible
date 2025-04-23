package unitTest

import org.junit.jupiter.api.BeforeEach
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * A test class for the AddUseCase class that ensures
 * the functionality of its add method which sums up integer arguments.
 */
class AddUseCaseTest {
    lateinit var addUseCase: AddUseCase
    @BeforeEach
    fun setup(){
        addUseCase = AddUseCase()
    }
    @Test
    fun `1 + 2 == 3`(){
        val result = addUseCase.add(1,2)
        assertEquals(3, result)
    }
}
