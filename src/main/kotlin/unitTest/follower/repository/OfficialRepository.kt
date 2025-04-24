package unitTest.follower.repository

import unitTest.follower.Follower

/**
 * 기업 사용자 Repo
 */
interface OfficialRepository {
    suspend fun searchByName(name:String):Array<Follower.OfficialAccount>
}