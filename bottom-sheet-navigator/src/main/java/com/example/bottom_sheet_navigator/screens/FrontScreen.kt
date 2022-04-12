package com.example.bottom_sheet_navigator.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen

class FrontScreen : Screen {

  @Composable
  override fun Content() {
    Text("This is the content of the bottom sheet")
  }
}