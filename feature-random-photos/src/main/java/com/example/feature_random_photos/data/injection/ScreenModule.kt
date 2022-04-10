package com.example.feature_random_photos.data.injection

import cafe.adriel.voyager.core.registry.screenModule
import com.example.feature_random_photos.navigation.SharedScreen.PhotosScreen
import com.example.feature_random_photos.ui.ShowPhotosListScreen

val featurePhotosModule = screenModule{
  register<PhotosScreen> {
    ShowPhotosListScreen()
  }
}
