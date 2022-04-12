package com.example.advanced_examples.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.domain.model.PostItem

@Composable
fun PostListScreen(postList: List<PostItem>) {
  LazyColumn(
      contentPadding = PaddingValues(horizontal = 8.dp, vertical = 16.dp),
      verticalArrangement = Arrangement.spacedBy(16.dp)
  ) {
    items(postList) { item ->
      PostCard(post = item)
    }
  }
}

@Composable
fun PostCard(post: PostItem) {
  val space = " "
  Card(
      shape = RoundedCornerShape(8.dp),
      modifier = Modifier
          .fillMaxWidth()
          .wrapContentHeight(),
      elevation = 2.dp,
      backgroundColor = MaterialTheme.colors.secondary
  ) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 8.dp)
    ) {
      Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
      ) {
        Text(text = "User id" + space.repeat(4) + post.userId, style = MaterialTheme.typography.h6)
        Text(text = "Id" + space.repeat(4) + post.id, style = MaterialTheme.typography.h6)
      }
      Text(text = post.title.orEmpty(), style = MaterialTheme.typography.body1)
      Text(text = post.body.orEmpty(), style = MaterialTheme.typography.body1)
    }
  }
}