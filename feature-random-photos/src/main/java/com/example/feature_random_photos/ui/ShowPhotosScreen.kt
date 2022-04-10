package com.example.feature_random_photos.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.feature_random_photos.data.model.PhotosResponseItem
import com.example.feature_random_photos.viewmodel.PhotosViewModel
import org.koin.androidx.compose.getViewModel

class ShowPhotosListScreen : Screen {
  @Composable
  override fun Content() {
    val photosViewModel: PhotosViewModel = getViewModel()
    val photosResponse = photosViewModel.photosResponse.collectAsState(null)
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(horizontal = 8.dp)
    ) {
      itemsIndexed(photosResponse.value ?: emptyList()) { index, item ->
        PhotoItem(item)
      }
    }
  }
}

@Composable
fun PhotoItem(item: PhotosResponseItem) {
  Card(
      modifier = Modifier
          .fillMaxWidth()
          .height(150.dp)
          .padding(vertical = 8.dp),
      shape = RoundedCornerShape(8.dp)
  ) {
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
      AsyncImage(
          model = ImageRequest.Builder(LocalContext.current)
              .data(item.url)
              .crossfade(true)
              .build(), contentDescription = null,
          modifier = Modifier.clip(CircleShape)
      )
      Column(
          modifier = Modifier
              .fillMaxWidth()
              .padding(horizontal = 8.dp),
          verticalArrangement = Arrangement.Center
      ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
          val stringBuilder: StringBuilder = StringBuilder()
          val spaces = stringBuilder.append(" ").repeat(4)
          Text("Id" + spaces + item.id)
          Text("Album Id" + spaces + item.albumId)
        }
        Text(item.title ?: "")
      }
    }
  }
}
