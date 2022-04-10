package com.example.feature_random_photos.navigation

import cafe.adriel.voyager.core.registry.ScreenProvider

sealed class SharedScreen : ScreenProvider{
  object PhotosScreen : SharedScreen()
}

