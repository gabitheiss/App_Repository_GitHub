package com.example.app_repositories_github.services

import com.example.app_repositories_github.model.User
import retrofit2.Call
import retrofit2.http.GET

interface UserService {

    @GET("/search/repositories?q=language:Java&sort=stars&page=1")
    fun getUsers(): Call<User>

}