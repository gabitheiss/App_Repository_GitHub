package com.example.app_repositories_github.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.app_repositories_github.R
import com.example.app_repositories_github.databinding.ListUsersBinding
import com.example.app_repositories_github.model.PullRequests
import com.example.app_repositories_github.model.Repository
import com.example.app_repositories_github.model.User



class AdapterList(val onClickList: (PullRequests) -> Unit, val user: User, val body: String, val title: String, val date: String) :
    RecyclerView.Adapter<AdapterList.UsersViewHolder>() {

    private var listRepositories: MutableList<Repository> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_users, parent, false)
        return UsersViewHolder(view)
    }

    fun onBindViewHolder(holder: UsersViewHolder, position: Int, pullRequests: PullRequests) {
        listRepositories[position].apply {
            holder.bind(this)

            holder.itemView.setOnClickListener {
                onClickList(pullRequests)
            }
        }


        fun refresh(repository: List<Repository>) {
            listRepositories = mutableListOf()
            listRepositories.addAll(repository)
            notifyDataSetChanged()
        }
    }


    class UsersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        private val binding = ListUsersBinding.bind(itemView)

        fun bind(repository: Repository) {

            binding.idNameRepo.text = repository.name
            binding.idNameUser.text = repository.owner.nameUser

            repository.let {
                Glide.with(itemView.context)
                    .load(it.owner.imageUser)
                    .into(binding.idImageUser)
            }
            binding.idDescription.text = repository.description
            binding.idStars.text = repository.stars
            binding.idForks.text = repository.forks
        }
    }

    override fun getItemCount(): Int {
        return listRepositories.size
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        listRepositories[position].apply {
            holder.bind(this)

            holder.itemView.setOnClickListener {
                onClickList(
                    PullRequests(user, title, body, date)
                )
            }
        }

    }
}