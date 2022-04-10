package com.example.navigation_compose.destinations

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen

data class ScreenA(
  val name: String
) : Screen {

  @Composable
  override fun Content() {
    Text(text = name)
  }
}
