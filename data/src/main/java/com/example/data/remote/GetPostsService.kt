package com.example.data.remote

import com.example.domain.model.PostItem
import retrofit2.http.GET

interface GetPostsService {
  @GET("posts")
  suspend fun getAllPosts(): List<PostItem>
}