package com.example.data.remote

import com.example.domain.model.PhotosResponseItem
import retrofit2.http.GET

interface GetPhotosService {
  @GET("photos")
  suspend fun getPhotos() : List<PhotosResponseItem>
}