package com.example.bottom_sheet_navigator.screens

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.bottomSheet.LocalBottomSheetNavigator

class BackScreen : Screen {

  @Composable
  override fun Content() {
    val bottomSheetNavigator = LocalBottomSheetNavigator.current

    Button(
        onClick = {
          bottomSheetNavigator.show(FrontScreen())
        },
        content = {
          Text("Show Bottom Sheet")
        }
    )
  }
}