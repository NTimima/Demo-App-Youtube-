package com.example.demoappyoutube

import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime

data class MyArticle(
    val id: Int,
    @SerializedName("username")
    val userName: String,
    val avatar: String,
    val email: String
)
