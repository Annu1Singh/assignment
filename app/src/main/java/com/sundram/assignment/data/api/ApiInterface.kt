package com.sundram.assignment.data.api

import com.sundram.assignment.data.datamodel.PostsItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("/posts")
    suspend fun getPosts(): Response<ArrayList<PostsItem>>

}