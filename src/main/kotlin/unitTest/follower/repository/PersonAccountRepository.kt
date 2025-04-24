package unitTest.follower.repository

import unitTest.follower.Follower

/**
 * 일반 사용자 Repo
 */
interface PersonAccountRepository {
    suspend fun searchByName(name:String):Array<Follower.PersonAccount>
}