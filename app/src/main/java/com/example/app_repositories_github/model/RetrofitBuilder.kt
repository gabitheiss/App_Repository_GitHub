package com.example.app_repositories_github.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {


    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()


//    fun getPokeService(): PokeService{
//        return retrofit.create(PokeService::class.java)
//
//    }

}