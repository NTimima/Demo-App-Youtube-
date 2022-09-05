package com.example.demoappyoutube

import android.provider.MediaStore
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewService {
    @GET("users/random_user")
    suspend fun getList(@Query("size") size: Int): Response<List<MyArticle>>

}
