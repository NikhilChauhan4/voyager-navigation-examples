package com.example.feature_random_photos.data.remote

import com.example.feature_random_photos.data.model.PhotosResponseItem
import retrofit2.http.GET

interface GetPhotosService {
  @GET("photos")
  suspend fun getPhotos() : List<PhotosResponseItem>
}