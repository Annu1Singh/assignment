package com.sundram.assignment.data.repository.datasourceimpl

import com.sundram.assignment.data.api.ApiInterface
import com.sundram.assignment.data.datamodel.PostsItem
import com.sundram.assignment.data.repository.datasource.GetPostRemoteDataSource
import retrofit2.Response

class GetPostRemoteDataSourceImpl(val apiInterface: ApiInterface) : GetPostRemoteDataSource {
    override suspend fun getPosts(): Response<ArrayList<PostsItem>> {
        return apiInterface.getPosts()
    }
}