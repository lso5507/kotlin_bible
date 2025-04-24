package unitTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import unitTest.user.FakeUserPhoneNumberRepository
import unitTest.user.StubUserNameRepository

class UserProfileFetcherTest{
  @Test
  fun `userNameRepo가 반환하는 이름이 홍길동이면 userProfileFether에서 userNameProfile을 가져왔을때 홍길동이어야한다`(){
      //stub 객체 생성하여 테스트
      val userProfileFetcher = UserProfileFetcher(
          usernameRepository = StubUserNameRepository(
            userNameMap = mapOf(
                "0x1111" to "홍길동",
                "0x2222" to "조세영"
            )
          ),
          userPhoneNumberRepository = FakeUserPhoneNumberRepository()
      )
      //when
      val userProfile = userProfileFetcher.getUserProfileById("0x1111")
      //then
      assertEquals(userProfile.name,"홍길동")
  }
    @Test
    fun `UserPhoneNumberRepository에 휴대폰 번호가 저장되어있으면, userNameProfile을 가져왔을 떄 해당 휴대폰 번호가 반환되어야함`(){
        //given
        val userProfileFetcher = UserProfileFetcher(
            usernameRepository = StubUserNameRepository(
                userNameMap = mapOf(
                    "0x1111" to "홍길동",
                    "0x2222" to "조세영"
                )
            ),
            //apply를 사용하여 Repo 관련 작업 수행가능
            userPhoneNumberRepository = FakeUserPhoneNumberRepository().apply{
                this.saveUserPhoneNumber("0x1111","010-1234-5678")
            }
        )
        //when
        val userProfile = userProfileFetcher.getUserProfileById("0x1111")
        //then
        assertEquals("010-1234-5678",userProfile.phoneNumber)
    }
 }