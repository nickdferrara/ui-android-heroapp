package com.nickdferrara.ui_android_heroapp.data.remote

import com.nickdferrara.ui_android_heroapp.domain.models.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface IBorutoApi {
    @GET("/boruto/heroes")
    suspend fun getAllHeroes(
        @Query("page") page: Int = 1
    ): ApiResponse

    @GET("/boruto/heroes/search")
    suspend fun searchHeroes(
        @Query("name") name: String
    ): ApiResponse
}