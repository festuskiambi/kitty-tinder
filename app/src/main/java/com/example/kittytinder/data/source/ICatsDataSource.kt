package com.example.kittytinder.data.source

import com.example.kittytinder.data.CatImage
import com.example.kittytinder.data.Vote

/**
 * Created by Festus Kiambi on 6/14/19.
 */
interface ICatsDataSource {

    suspend fun getCatImages(): List<CatImage>?

    suspend fun saveVote(vote : Vote)
}