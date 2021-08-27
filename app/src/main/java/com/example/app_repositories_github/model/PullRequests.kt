package com.example.app_repositories_github.model

import com.google.gson.annotations.SerializedName

data class PullRequests(
    @SerializedName("user") val user : User,
    val title : String,
    val body : String,
    @SerializedName("created_at") val date : String
)


data class User(
    @SerializedName("login") val nameUserPull : String,
    @SerializedName("avatar_url") val imageUserPull : String
)