package com.example.posts.repository

import com.example.posts.Api.ApiClient
import com.example.posts.Api.ApiInterface
import com.example.posts.models.Posts
import com.example.posts.models.PostsResponse

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class PostsRepository {
    private val apiClient=ApiClient.buildClient(ApiInterface::class.java)
    suspend fun getPosts(): Response<List<Posts>> {
        return withContext(Dispatchers.IO){
            apiClient.getPosts()
    }
}
}