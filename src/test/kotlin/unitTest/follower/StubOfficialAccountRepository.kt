package unitTest.follower

import kotlinx.coroutines.delay
import unitTest.follower.repository.OfficialRepository

class StubOfficialAccountRepository(
    private val users:List<Follower.OfficialAccount>
):OfficialRepository {
    override suspend fun searchByName(name: String): Array<Follower.OfficialAccount> {
        delay(1000L)
        return users.filter{ user->
            user.name.contains(name)
        }.toTypedArray()
    }
}