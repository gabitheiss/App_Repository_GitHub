package com.example.app_repositories_github.model

import android.media.Image
import com.google.gson.annotations.SerializedName
import retrofit2.http.Url
import java.util.*

data class User(
    @SerializedName("items") val itens : Objects,
    val id : Id,
    val name : Name,
    val owner : Owner,
    val nameUser : Login,
    val imageUser : ImageUser,
    val description : Description,
    val stars: Stars,
    val forks : Forks

)

data class Id(
    @SerializedName("id") val id : String
)
data class Name(
    @SerializedName("name") val name : String
)
data class Owner(
    @SerializedName("owner") val owner : Objects
)
data class Login(
    @SerializedName("login") val nameUser : String
)
data class ImageUser(
    @SerializedName("avatar_url") val imageUser : Url
)
data class Description(
    @SerializedName("description") val description : String
)
data class Stars(
    @SerializedName("stargazers_count") val stars : String
)
data class Forks(
    @SerializedName("forks_count") val forks : String
)


