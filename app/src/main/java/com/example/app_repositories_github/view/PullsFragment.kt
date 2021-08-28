package com.example.app_repositories_github.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app_repositories_github.R
import com.example.app_repositories_github.adapter.AdapterPulls
import com.example.app_repositories_github.databinding.ListPullsBinding
import com.example.app_repositories_github.databinding.MainFragmentBinding
import com.example.app_repositories_github.databinding.PullsFragmentBinding
import com.example.app_repositories_github.model.PullRequests
import com.example.app_repositories_github.model.Repository
import com.example.app_repositories_github.view_model.MainViewModel
import com.example.app_repositories_github.view_model.PullsViewModel
import com.google.android.material.snackbar.Snackbar

class PullsFragment : Fragment(R.layout.pulls_fragment) {

    companion object {
        fun newInstance() = PullsFragment()
    }

    private lateinit var viewModel: PullsViewModel
    private lateinit var recyclerView: RecyclerView
    private  var adapter = AdapterPulls(){ }
    private lateinit var binding : PullsFragmentBinding


    private val pullObserver = Observer<List<PullRequests>?> { newList ->
        adapter.refresh(newList)
    }
    private val errorObserver = Observer<String> { error ->
        Snackbar.make(requireView(), error, Snackbar.LENGTH_LONG).show()
    }
    

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerViewPulls)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        binding = PullsFragmentBinding.bind(view)

        viewModel = ViewModelProvider(this).get(PullsViewModel::class.java)
        viewModel.pullsResponse.observe(viewLifecycleOwner,pullObserver)
        viewModel.error.observe(viewLifecycleOwner,errorObserver)
        viewModel.fetchPulls(requireContext())
    }

}