package com.example.demoappyoutube

import android.app.Application

class Repository {
    private val retrofit = AppModule.provideNewsService()

    suspend fun getListServer(size: Int): List<MyArticle> {
        val response = retrofit.getList(size)
        return if(response.isSuccessful && response.body() != null) response.body()!! else listOf()
    }

}