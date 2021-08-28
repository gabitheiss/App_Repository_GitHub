package com.example.app_repositories_github.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.app_repositories_github.R
import com.example.app_repositories_github.view_model.PullsViewModel

class PullsFragment : Fragment(R.layout.pulls_fragment) {

    companion object {
        fun newInstance() = PullsFragment()
    }

    private lateinit var viewModel: PullsViewModel



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PullsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}