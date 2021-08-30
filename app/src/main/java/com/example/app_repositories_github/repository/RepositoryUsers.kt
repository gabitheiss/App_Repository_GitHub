package com.example.app_repositories_github.repository

import com.example.app_repositories_github.model.PullRequests
import com.example.app_repositories_github.model.Repositories
import com.example.app_repositories_github.services.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoryUsers () {


    val service = RetrofitBuilder.getUserService()
    val servicePull = RetrofitBuilder.getPullsRequests()


    fun searchRepo(onComplete: (Repositories?, String?) -> Unit) {
        val callRepo = service.getUsers()
        callRepo.clone().enqueue(object : Callback<Repositories> {

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
    fun fecthPull(nameUser: String, name: String, onComplete: (List<PullRequests>?, String?) -> Unit) {
        val callPull = servicePull.getPulls(nameUser, name)
        callPull.enqueue(object : Callback<List<PullRequests>> {
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
