package com.example

import android.app.Application
import cafe.adriel.voyager.core.registry.ScreenRegistry
import com.example.advanced_examples.injection.postModule
import com.example.advanced_examples.screens.PostsScreen
import com.example.bottom_sheet_navigator.screens.BackScreen
import com.example.data.injection.networkModule
import com.example.data.repository.fetchPhotosModule
import com.example.data.repository.fetchPostsModule
import com.example.feature_random_photos.injection.featurePhotosModule
import com.example.feature_random_photos.viewmodel.viewModelModule
import com.example.navigation.SharedScreen
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class NavigationApplication : Application() {

  override fun onCreate() {
    super.onCreate()

    startKoin {
      androidContext(this@NavigationApplication)
      modules(networkModule, fetchPhotosModule , viewModelModule,fetchPostsModule,postModule)
    }

    ScreenRegistry{
      featurePhotosModule()

      register<SharedScreen.BottomSheetScreen> {
        BackScreen()
      }
      register<SharedScreen.ShowPostsScreen> {
        PostsScreen()
      }
    }
  }
}