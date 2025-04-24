package unitTest.user

import unitTest.UserNameRepository

class StubUserNameRepository(
    private val userNameMap:Map<String,String>
):UserNameRepository {

    override fun saveUserName(id: String, name: String) {
    }

    override fun getNameByUserId(id: String): String {
        return userNameMap[id] ?:""
    }

}