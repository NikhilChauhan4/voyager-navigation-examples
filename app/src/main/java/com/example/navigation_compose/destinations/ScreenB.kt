package com.example.navigation_compose.destinations

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen

object ScreenB : Screen {

  @Composable
  override fun Content() {
    Text(text = "I am at Screen B")
  }
}