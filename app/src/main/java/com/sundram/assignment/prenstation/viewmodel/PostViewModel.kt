package com.sundram.assignment.prenstation.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.anushka.newsapiclient.data.util.Resource
import com.sundram.assignment.data.datamodel.PostsItem
import com.sundram.assignment.domain.usecases.GetPostUsesCases
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import kotlin.Exception

class PostViewModel(
    private val app: Application,
    private val getPostUsesCases: GetPostUsesCases
) : AndroidViewModel(app) {
    val getPostLiveData: MutableLiveData<ArrayList<PostsItem>> = MutableLiveData()

    fun execute() = viewModelScope.launch(Dispatchers.IO) {
        try {
            val response = getPostUsesCases.execute()
            getPostLiveData.postValue(ArrayList())
            response.body()?.let {
                getPostLiveData.postValue(response.body())
            }

        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }

}














