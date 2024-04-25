package com.sundram.assignment.domain.repository

import com.sundram.assignment.data.datamodel.PostsItem
import retrofit2.Response

interface Repository {

    suspend fun getPosts(): Response<ArrayList<PostsItem>>

}