package com.sundram.assignment.data.repository.datasource

import com.sundram.assignment.data.datamodel.PostsItem
import retrofit2.Response

interface GetPostRemoteDataSource {
    suspend fun getPosts(): Response<ArrayList<PostsItem>>
}