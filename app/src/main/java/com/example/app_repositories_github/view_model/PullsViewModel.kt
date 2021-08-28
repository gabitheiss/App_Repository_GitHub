package com.example.app_repositories_github.view_model


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.app_repositories_github.model.PullRequests
import com.example.app_repositories_github.repository.RepositoryPulls


class PullsViewModel : ViewModel() {

    private val repository = RepositoryPulls()

    val _pullsResponse = MutableLiveData<List<PullRequests>?>()
    val pullsResponse : LiveData<List<PullRequests>?> = _pullsResponse

    val _error = MutableLiveData<String>()
    var error : LiveData<String> = _error

    fun fetchPulls(nameUser : String, nameREspository : String) {
        repository.searchPulls(nameUser,nameREspository){
            _pullsResponse.value
        }

    }

}