package com.example.advanced_examples.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import com.example.advanced_examples.PostsScreenModel
import com.example.advanced_examples.State.Loading
import com.example.advanced_examples.State.Result

class PostsScreen : Screen {

  @Composable
  override fun Content() {
    val screenModel = getScreenModel<PostsScreenModel>()
    val state by screenModel.state.collectAsState()

    if (screenModel.showProgressDialog.value) {
      ShowLoadingDialog(screenModel)
    }
    when (state) {
      is Loading -> {
        screenModel.showProgressDialog.value = true
      }
      is Result -> {
        PostListScreen(postList = (state as Result).posts)
        screenModel.showProgressDialog.value = false
      }

      else -> {

      }
    }
  }

  @Composable
  fun ShowLoadingDialog(screenModel: PostsScreenModel) {
    Dialog(
        onDismissRequest = {
          screenModel.showProgressDialog.value = false
        }, properties = DialogProperties(
        dismissOnBackPress = false,
        dismissOnClickOutside = false
    )
    ) {
      Box(
          contentAlignment = Alignment.Center,
          modifier = Modifier
              .size(150.dp)
              .background(color = Color.White, shape = RoundedCornerShape(8.dp)),
          content = { CircularProgressIndicator() }
      )
    }
  }
}