package com.example.app_repositories_github.repository

import android.content.Context
import com.example.app_repositories_github.model.PullRequests
import com.example.app_repositories_github.model.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RepositoryPulls() {

    val servicePull = RetrofitBuilder.getPullsRequests()


    fun searchPulls(nameUser : String, nameRepository : String, callback: (Boolean) -> Unit) {
        val call = servicePull.getPull(nameUser,nameRepository)
        call.clone().enqueue(object : Callback<List<PullRequests>> {
            override fun onResponse(
                call: Call<List<PullRequests>>,
                response: Response<List<PullRequests>>
            ) {
                if (response.body() != null) {
                    callback(true)
                } else {
                    false
                }
            }
            override fun onFailure(call: Call<List<PullRequests>>, t: Throwable) {
                t.message
            }

        })
    }
}