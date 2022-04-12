package com.example.navigation

import cafe.adriel.voyager.core.registry.ScreenProvider

sealed class SharedScreen : ScreenProvider {
  object BottomSheetScreen : SharedScreen()
  object ShowPostsScreen : SharedScreen()
}
