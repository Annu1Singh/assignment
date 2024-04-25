package com.sundram.assignment.data.repository.repositoryimpl

import com.sundram.assignment.data.datamodel.PostsItem
import com.sundram.assignment.data.repository.datasource.GetPostRemoteDataSource
import com.sundram.assignment.domain.repository.Repository
import retrofit2.Response

class RepositoryImpl(private val getPostRemoteDataSource: GetPostRemoteDataSource) : Repository {
    override suspend fun getPosts(): Response<ArrayList<PostsItem>> {
        return getPostRemoteDataSource.getPosts()
    }
}