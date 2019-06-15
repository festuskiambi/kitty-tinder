package com.example.kittytinder.data.source.remote

import com.example.kittytinder.data.CatImage
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Festus Kiambi on 6/14/19.
 */
interface ApiInterface {

    @GET("images/search")
    suspend fun getCatImages(
        @Query("x-api-key") apiKey: String,
        @Query("limit") limit: Int
    ): Response<List<CatImage>>
}