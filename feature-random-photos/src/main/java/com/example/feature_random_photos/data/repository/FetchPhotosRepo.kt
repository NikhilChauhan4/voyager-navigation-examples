package com.example.feature_random_photos.data.repository

import com.example.feature_random_photos.data.remote.GetPhotosService
import org.koin.dsl.module

class FetchPhotosRepo(private val getPhotosService: GetPhotosService) {
  suspend fun fetchPhotos() = getPhotosService.getPhotos()
}

val fetchPhotosModule = module {
  factory {
    FetchPhotosRepo(get())
  }
}