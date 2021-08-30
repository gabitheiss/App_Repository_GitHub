package com.example.app_repositories_github.services

import com.example.app_repositories_github.model.PullRequests
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PullService {

    @GET("/repos/{nameUser}/{nameRepository}/pulls/")

    fun getPulls(
        @Path("nameUser") nameUser: String,
        @Path("nameRepository") name: String
    ): Call<List<PullRequests>>
}
