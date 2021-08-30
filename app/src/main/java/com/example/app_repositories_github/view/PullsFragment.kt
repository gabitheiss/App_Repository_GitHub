package com.example.app_repositories_github.view

import android.content.Intent
import android.net.Uri
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.View
import androidx.core.content.ContentProviderCompat.requireContext
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


const val OWNER = "owner"
const val REPO = "repo_key"

class PullsFragment : Fragment(R.layout.pulls_fragment) {



    companion object {
        fun newInstance(nameUser: String, name: String): PullsFragment {
            return PullsFragment().apply {
                val args = Bundle()
                args.putString(OWNER, nameUser)
                args.putString(REPO, name)
                this.arguments = args
            }
        }
    }

    private lateinit var viewModel: PullsViewModel
    private lateinit var binding: PullsFragmentBinding
    private var adapter = AdapterPulls {
        val browserOpen = Intent(Intent.ACTION_VIEW, Uri.parse(it.urlHTML))
        startActivity(browserOpen)
    }


    private val pullObserver = Observer<List<PullRequests>?> { newList ->
        adapter.refresh(newList)
    }

    private val errorObserver = Observer<String> { error ->
        Snackbar.make(requireView(), error, Snackbar.LENGTH_LONG).show()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(PullsViewModel::class.java)
        binding = PullsFragmentBinding.bind(view)

        binding.recyclerViewPulls.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewPulls.adapter = adapter


        viewModel.pullsResponse.observe(viewLifecycleOwner, pullObserver)
        viewModel.error.observe(viewLifecycleOwner, errorObserver)

        val owner = arguments?.getString(OWNER)
        val repo = arguments?.getString(REPO)
        viewModel.fetchPulls(owner.toString(),repo.toString())

    }
}