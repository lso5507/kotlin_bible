package unitTest.follower

import kotlinx.coroutines.delay
import unitTest.follower.repository.PersonAccountRepository

class StubPersonAccountRepository(
    private val users:List<Follower.PersonAccount>
):PersonAccountRepository {
    override suspend fun searchByName(name: String): Array<Follower.PersonAccount> {
        delay(1000L)
        return users.filter{ user->
            user.name.contains(name)
        }.toTypedArray()
    }
}