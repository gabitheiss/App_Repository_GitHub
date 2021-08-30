package com.example.app_repositories_github.model

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.app_repositories_github.R

fun FragmentActivity.replaceFragment(fragment: Fragment, @IdRes recyclerView: Int = R.id.container){
    supportFragmentManager.beginTransaction()
        .replace(recyclerView, fragment)
        .commitNow()
}