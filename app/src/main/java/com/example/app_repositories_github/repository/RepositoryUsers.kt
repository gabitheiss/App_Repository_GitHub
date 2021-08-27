package com.example.app_repositories_github.repository

import android.content.Context
import com.example.app_repositories_github.model.Repositories
import com.example.app_repositories_github.model.Repository
import com.example.app_repositories_github.model.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoryUsers (private val context : Context) {


    val service = RetrofitBuilder.getUserService()


    fun searchRepo(onComplete: (Repositories?, String?) -> Unit) {
        val call = service.getUsers()
        call.enqueue(object : Callback<Repositories> {

            override fun onResponse(call: Call<Repositories>, response: Response<Repositories>) {
                if (response.body() != null) {
                    onComplete(response.body(), null)
                } else {
                    onComplete(null, "Erro")
                }
            }

            override fun onFailure(call: Call<Repositories>, t: Throwable) {
                onComplete(null,t.message)
            }


        })
    }
}