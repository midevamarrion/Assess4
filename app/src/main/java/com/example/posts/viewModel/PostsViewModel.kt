package com.example.posts.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.posts.models.Posts
import com.example.posts.repository.PostsRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class PostsViewModel:ViewModel() {
      val postsRepo= PostsRepository()
    var postLiveData= MutableLiveData<List<Posts>>()
    var errorLiveData=MutableLiveData<String>()
      fun fetchPosts(){
        viewModelScope.launch {
            val response =postsRepo.getPosts()
            if (response.isSuccessful){
                val posts=response.body()?: emptyList()

                postLiveData.postValue(posts)
            }
            else{
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }

}
