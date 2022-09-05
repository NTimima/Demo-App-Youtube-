package com.example.demoappyoutube

import android.app.Application

interface Component {
    fun inject(homeActivity: MainActivity)

    interface Builder {

        fun application(application: Application): Builder

    }
}