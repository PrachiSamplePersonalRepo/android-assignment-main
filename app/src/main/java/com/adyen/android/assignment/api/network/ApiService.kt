package com.adyen.android.assignment.api.network

import com.adyen.android.assignment.BuildConfig
import com.adyen.android.assignment.api.model.AstronomyApiResponse
import com.adyen.android.assignment.api.model.AstronomyPicture
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    /* @GET("planetary/apod?count=20&api_key=${BuildConfig.API_KEY}")
     suspend fun getPictures(): Response<List<AstronomyPicture>>
 */
    @GET("/planetary/apod?&api_key=${BuildConfig.API_KEY}")
    suspend fun getPictures(
        @Query("page") page: Int = 20,
    ): Response<AstronomyApiResponse>
}