package com.example.app_repositories_github.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.app_repositories_github.R
import com.example.app_repositories_github.databinding.PullsFragmentBinding
import com.example.app_repositories_github.model.PullRequests
import com.example.app_repositories_github.model.Repository

class AdapterPulls(val onClickList: (PullRequests) -> Unit) :
    RecyclerView.Adapter<PullRequestsViewHolder>() {

    private var listOfPulls: MutableList<PullRequests> = mutableListOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PullRequestsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_pulls, parent, false)
        return PullRequestsViewHolder(view)
    }


    override fun onBindViewHolder(holder: PullRequestsViewHolder, position: Int) {
        listOfPulls[position].apply {
            holder.bind(this)
            holder.itemView.setOnClickListener { onClickList(this) }
        }
    }


    override fun getItemCount(): Int = listOfPulls.size


    fun refresh(pullRequests: List<PullRequests>) {
        listOfPulls = mutableListOf()
        listOfPulls.addAll(pullRequests)
        notifyDataSetChanged()
    }
}




class PullRequestsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val binding = PullsFragmentBinding.bind(itemView)

    fun bind(pullRequests: PullRequests) {

        pullRequests.let {
            Glide.with(itemView.context)
                .load(it.user.imageUserPull)
                .into(binding.idImageUserPull)
        }
        binding.idTitle.text = pullRequests.title
        binding.idNameUserPull.text = pullRequests.user.nameUserPull
        binding.idBody.text = pullRequests.body
        binding.idDate.text = pullRequests.date
    }
}