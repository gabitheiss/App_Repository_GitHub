package com.example.app_repositories_github.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app_repositories_github.R
import com.example.app_repositories_github.adapter.AdapterList
import com.example.app_repositories_github.databinding.MainFragmentBinding
import com.example.app_repositories_github.model.Repository
import com.example.app_repositories_github.view_model.MainViewModel
import com.google.android.material.snackbar.Snackbar


class MainFragment : Fragment(R.layout.main_fragment) {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    lateinit var binding: MainFragmentBinding
    lateinit var recyclerView: RecyclerView
    var adapter = AdapterList(){ click ->
        viewModel.fetchRepositories(click.owner.nameUser, click.name)
        requireActivity().replaceView(PullsFragment())
    }



    private val repositoryObserver = Observer<List<Repository>> { newList ->
        adapter.refresh(newList)
    }
    private val errorObserver = Observer<String> { error ->
        Snackbar.make(requireView(), error, Snackbar.LENGTH_LONG).show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerViewContainer)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        binding = MainFragmentBinding.bind(view)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.repositoryResponse.observe(viewLifecycleOwner,repositoryObserver)
        viewModel.error.observe(viewLifecycleOwner,errorObserver)
        viewModel.fetchRepositories(requireContext())


    }

}