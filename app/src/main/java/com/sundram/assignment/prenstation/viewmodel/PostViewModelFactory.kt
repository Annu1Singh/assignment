package com.sundram.assignment.prenstation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sundram.assignment.domain.usecases.GetPostUsesCases

class PostViewModelFactory(
    private val app: Application,
    private val getPostUsesCases: GetPostUsesCases
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PostViewModel(
            app,
            getPostUsesCases
        ) as T
    }
}









