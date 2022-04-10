package com.example.navigation_compose.tab_navigator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.example.feature_random_photos.viewmodel.PhotosViewModel
import com.example.feature_random_photos.viewmodel.getViewModel
import com.example.navigation_compose.tab_navigator.tabs.HomeTab
import com.example.navigation_compose.tab_navigator.tabs.ProfileTab
import com.example.navigation_compose.tab_navigator.tabs.SettingTab

@Composable
fun TabNavigation() {
  TabNavigator(HomeTab) {
    val vm = getViewModel<PhotosViewModel>()
    Scaffold(
        content = {
          Column(
              modifier = Modifier.fillMaxSize(),
              verticalArrangement = Arrangement.Center,
              horizontalAlignment = Alignment.CenterHorizontally
          ) {
            CurrentTab()
          }
        },
        bottomBar = {
          BottomNavigation {
            TabNavigationItem(HomeTab)
            TabNavigationItem(ProfileTab)
            TabNavigationItem(SettingTab)
          }
        },
    )
  }
}

@Composable
private fun RowScope.TabNavigationItem(tab: Tab) {
  val tabNavigator = LocalTabNavigator.current

  BottomNavigationItem(
      selected = tabNavigator.current == tab,
      onClick = { tabNavigator.current = tab },
      icon = {
        tab.options.icon?.let {
          Icon(
              painter = it, contentDescription = tab.options.title
          )
        }
      }
  )
}