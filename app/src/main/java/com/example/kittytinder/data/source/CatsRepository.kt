package com.example.kittytinder.data.source

import com.example.kittytinder.data.CatImage
import com.example.kittytinder.data.Vote
import com.example.kittytinder.data.source.local.VoteDao
import com.example.kittytinder.data.source.remote.ApiInterface
import com.example.kittytinder.util.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by Festus Kiambi on 6/14/19.
 */
class CatsRepository @Inject constructor(
    private val apiInterface: ApiInterface,
    private val votesDao: VoteDao
) : ICatsDataSource {
    override suspend fun getCatImages(): List<CatImage>? {
        return apiInterface.getCatImages(Constants.API_KEY, 100).body()
    }

    override suspend fun saveVote(vote: Vote) = withContext(Dispatchers.IO) {
        votesDao.insertVote(vote)
    }
}