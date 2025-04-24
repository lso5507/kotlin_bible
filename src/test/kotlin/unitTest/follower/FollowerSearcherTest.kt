package unitTest.follower

import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import unitTest.follower.repository.OfficialRepository
import unitTest.follower.repository.PersonAccountRepository

class FollowerSearcherTest{
    private lateinit var followerSearcher: FollowerSearcher
    companion object{
        private val companyA = Follower.OfficialAccount(id="0x0000",name="CompanyA")
        private val companyB = Follower.OfficialAccount(id="0x0001",name="CompanyB")
        private val companyC = Follower.OfficialAccount(id="0x0002",name="CompanyC")

        private val personA = Follower.PersonAccount(id="0x1000",name="PersonA")
        private val personB = Follower.PersonAccount(id="0x1001",name="PersonB")
        private val personC = Follower.PersonAccount(id="0x1002",name="PersonC")


    }
    private val stubOfficialAccountRepository = StubOfficialAccountRepository(
        users = listOf(companyA, companyB, companyC)
    )
    private val stubPersonAccountRepository = StubPersonAccountRepository(
        users = listOf(personA, personB, personC)
    )
    @BeforeEach
    fun setup(){
        //mock 객체로 생성
        followerSearcher = FollowerSearcher(
            officialAccountRepository = stubOfficialAccountRepository,
            personAccountRepository = stubPersonAccountRepository
        )
    }

    @Test
    fun `공식계정과 개인계정이 합쳐서 반환되는지 테스트`()= runTest{
        //given
        val searchName = "A"
        val expectedResults = listOf(companyA, personA)
        //when
        val results= followerSearcher.searchByName(searchName)
        //then
        assertEquals(expectedResults,results)
    }
 }