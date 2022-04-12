package com.example.data.repository

import com.example.data.remote.GetPhotosService
import org.koin.dsl.module

class FetchPhotosRepo(private val getPhotosService: GetPhotosService) {
  suspend fun fetchPhotos() = getPhotosService.getPhotos()
}

val fetchPhotosModule = module {
  factory {
    FetchPhotosRepo(get())
  }
}