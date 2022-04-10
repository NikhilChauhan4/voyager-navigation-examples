package com.example.navigation_compose.tab_navigator.tabs

import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions

object HomeTab : Tab {
  override val options: TabOptions
    @Composable
    get() {
      val title = "Home"
      val icon = rememberVectorPainter(image = Icons.Default.Home)

      return remember {
        TabOptions(
            index = 0u,
            title = title,
            icon = icon
        )
      }
    }

  @Composable
  override fun Content() {
    // TabContent(name = "Home")
  }
}

object ProfileTab : Tab {
  override val options: TabOptions
    @Composable
    get() {
      val title = "Profile"
      val icon = rememberVectorPainter(image = Icons.Default.Person)

      return remember {
        TabOptions(
            index = 1u,
            title = title,
            icon = icon
        )
      }
    }

  @Composable
  override fun Content() {
    TabContent(name = "Profile")
  }
}

object SettingTab : Tab {
  override val options: TabOptions
    @Composable
    get() {
      val title = "Settings"
      val icon = rememberVectorPainter(image = Icons.Default.Settings)

      return remember {
        TabOptions(
            index = 1u,
            title = title,
            icon = icon
        )
      }
    }

  @Composable
  override fun Content() {
    TabContent(name = "Settings")
  }
}

@Composable
fun TabContent(name: String) {
  Text(text = name)
}