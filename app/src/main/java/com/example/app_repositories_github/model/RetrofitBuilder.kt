package com.example.app_repositories_github.model

import com.example.app_repositories_github.services.PullService
import com.example.app_repositories_github.services.UserService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {


    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    fun getUserService(): UserService{
        return retrofit.create(UserService::class.java)
    }

    fun getPullsRequests(): PullService {
        return retrofit.create(PullService::class.java)
    }

}