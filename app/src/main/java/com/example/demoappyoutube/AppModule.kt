package com.example.demoappyoutube

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AppModule {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://random-data-api.com/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    fun provideNewsService(): NewService {
        return retrofit.create(NewService::class.java)
    }
}