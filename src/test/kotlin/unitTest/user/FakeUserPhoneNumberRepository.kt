package unitTest.user

import unitTest.UserPhoneNumberRepository

class FakeUserPhoneNumberRepository :UserPhoneNumberRepository{
    private val  userPhoneNumberMap = mutableMapOf<String,String>()
    override fun saveUserPhoneNumber(id: String, phoneNumber: String) {
        userPhoneNumberMap[id]=phoneNumber
    }

    override fun getUserPhoneNumberByUserId(id: String): String {
        return userPhoneNumberMap[id]?:""
    }

}