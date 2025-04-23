package unitTest

interface UserPhoneNumberRepository {
    fun saveUserPhoneNumber(id:String, phoneNumber:String)
    fun getUserPhoneNumberByUserId(id:String):String
}