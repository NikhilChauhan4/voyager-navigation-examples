package com.example.advanced_examples

import androidx.compose.runtime.mutableStateOf
import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import com.example.advanced_examples.State.Loading
import com.example.data.repository.FetchPostsRepo
import com.example.domain.model.PostItem
import kotlinx.coroutines.launch

class PostsScreenModel(private val repository: FetchPostsRepo) : StateScreenModel<State>(
    State.Init
) {
  init {
    getPosts()
  }
  val showProgressDialog = mutableStateOf(false)
  fun getPosts(){
    coroutineScope.launch {
      mutableState.value = Loading
      mutableState.value = State.Result(posts = repository.fetchPosts())
    }
  }
}

sealed class State {
  object Init : State()
  object Loading : State()
  data class Result(val posts: List<PostItem>) : State()
}