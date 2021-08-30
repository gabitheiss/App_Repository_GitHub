package com.example.app_repositories_github.view_model


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.app_repositories_github.model.PullRequests
import com.example.app_repositories_github.repository.RepositoryPulls
import com.example.app_repositories_github.repository.RepositoryUsers


class PullsViewModel : ViewModel() {

    val _pullsResponse = MutableLiveData<List<PullRequests>?>()
    val pullsResponse: LiveData<List<PullRequests>?> = _pullsResponse

    val _error = MutableLiveData<String>()
    var error: LiveData<String> = _error

    fun fetchPulls(nameUser: String, name: String) {
        val repository = RepositoryUsers()

        if (!nameUser.isNullOrEmpty() && !name.isNullOrEmpty()) {
            repository.fecthPull(nameUser, name) { response, error ->
                response?.apply {
                    _pullsResponse.value = response
                }

                error?.let {
                    _error.value
                }
            }
            error?.let {
                _error.value
            }
        }
    }
}


