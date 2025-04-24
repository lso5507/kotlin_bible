package unitTest.follower

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import unitTest.follower.repository.OfficialRepository
import unitTest.follower.repository.PersonAccountRepository

class FollowerSearcher(
    private val officialAccountRepository:OfficialRepository,
    private val personAccountRepository:PersonAccountRepository,
) {
    // 코루틴으로 실행
    suspend fun searchByName(name:String):List<Follower> = coroutineScope {
        val officialAccountDeferred = async{
            officialAccountRepository.searchByName(name)
        }
        val personAccountDeferred = async {
            personAccountRepository.searchByName(name)
        }
        return@coroutineScope listOf(
            *officialAccountDeferred.await(),
            *personAccountDeferred.await()
        )
    }

}