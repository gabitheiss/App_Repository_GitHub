package com.example.app_repositories_github.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


data class UserResponse(val results : List<User>)




@Entity
data class IdUser(

    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id") val id: String,

)