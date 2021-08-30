package com.example.app_repositories_github.repository

import com.example.app_repositories_github.model.PullRequests
import com.example.app_repositories_github.services.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RepositoryPulls() {

    val servicePull = RetrofitBuilder.getPullsRequests()


    fun searchPulls(nameUser : String, name : String, onComplete: (List<PullRequests>?, String?) -> Unit) {
        val call = servicePull.getPulls(nameUser,name)
        call.clone().enqueue(object : Callback<List<PullRequests>> {
            override fun onResponse(
                call: Call<List<PullRequests>>,
                response: Response<List<PullRequests>>
            ) {
                if (response.body() != null) {
                    onComplete(response.body(), null)
                } else {
                    onComplete(null, "Erro")
                }
            }
            override fun onFailure(call: Call<List<PullRequests>>, t: Throwable) {
                onComplete(null, t.message)
            }
        })
    }
}