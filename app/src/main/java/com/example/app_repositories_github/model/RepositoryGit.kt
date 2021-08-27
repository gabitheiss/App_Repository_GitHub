package com.example.app_repositories_github.model


import com.google.gson.annotations.SerializedName


data class Repositories(
    @SerializedName("items") val itens: List<Repository>
)

data class Repository(
    val name: String,
    val owner: Owner,
    val description: String,
    @SerializedName("pulls_url") val pulls : String,
    @SerializedName("stargazers_count") val stars: String,
    @SerializedName("forks_count") val forks: String

)

data class Owner(
    @SerializedName("login") val nameUser: String,
    @SerializedName("avatar_url") val imageUser: String
)


