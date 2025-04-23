package unitTest

class UserProfileFetcher(
    private val usernameRepository:UserNameRepository,
    private val userPhoneNumberRepository:UserPhoneNumberRepository
) {
    fun getUserProfileById(id:String):UserProfile{
        //유저 이름을 UserNameRepository에서 가져옴
        val userName = usernameRepository.getNameByUserId(id)
        // get UserPhoneNum
        val userPhoneNumber = userPhoneNumberRepository.getUserPhoneNumberByUserId(id)
        return UserProfile(
            id = id,
            name = userName,
            phoneNumber = userPhoneNumber
        )
    }
}