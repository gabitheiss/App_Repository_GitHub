package com.example.app_repositories_github.view_model


import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.app_repositories_github.model.Repositories
import com.example.app_repositories_github.model.Repository
import com.example.app_repositories_github.repository.RepositoryUsers


class MainViewModel : ViewModel() {

    val _repositoryResponse = MutableLiveData<List<Repository>>()
    val repositoryResponse : LiveData<List<Repository>> = _repositoryResponse

    val _error = MutableLiveData<String>()
    var error : LiveData<String> = _error

    fun fetchRepositories(context: Context) {
        val repository = RepositoryUsers(context)
        repository.searchRepo { response, error ->
            response?.let {
                _repositoryResponse.value = it.itens

            }
            error?.let {
                _error.value = it
            }
        }
    }



}