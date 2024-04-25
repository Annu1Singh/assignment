package com.sundram.assignment.domain.usecases

import com.sundram.assignment.data.datamodel.PostsItem
import com.sundram.assignment.domain.repository.Repository
import retrofit2.Response

class GetPostUsesCases(private val repository: Repository) {

    suspend fun execute(): Response<ArrayList<PostsItem>> {
        return repository.getPosts()
    }

}