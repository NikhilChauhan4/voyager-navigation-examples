package com.example.data.repository

import com.example.data.remote.GetPostsService
import com.example.domain.model.PostItem
import org.koin.dsl.module

class FetchPostsRepo(private val getPostsService: GetPostsService) {
  suspend fun fetchPosts(): List<PostItem> = getPostsService.getAllPosts()
}

val fetchPostsModule = module {
  factory {
    FetchPostsRepo(get())
  }
}