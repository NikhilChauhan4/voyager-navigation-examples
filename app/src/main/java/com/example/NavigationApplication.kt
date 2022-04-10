package com.example

import android.app.Application
import cafe.adriel.voyager.core.registry.ScreenRegistry
import com.example.feature_random_photos.data.injection.featurePhotosModule
import com.example.feature_random_photos.data.injection.networkModule
import com.example.feature_random_photos.data.repository.fetchPhotosModule
import com.example.feature_random_photos.viewmodel.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class NavigationApplication : Application() {

  override fun onCreate() {
    super.onCreate()

    startKoin {
      androidContext(this@NavigationApplication)
      modules(networkModule, fetchPhotosModule, viewModelModule)
    }

    ScreenRegistry{
      featurePhotosModule()
    }
  }
}