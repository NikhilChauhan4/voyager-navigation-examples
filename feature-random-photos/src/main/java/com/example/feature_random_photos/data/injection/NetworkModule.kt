package com.example.feature_random_photos.data.injection

import com.example.feature_random_photos.data.remote.GetPhotosService
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Constants{
  const val BASE_URL = "https://jsonplaceholder.typicode.com/"
}

val networkModule = module{
  factory {
    provideOkHttpClient()
  }
  factory {
    provideRandomPhotosApi(get())
  }
  single {
    provideRetrofit(get())
  }
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit{
  return Retrofit.Builder().baseUrl(Constants.BASE_URL).client(okHttpClient)
      .addConverterFactory(GsonConverterFactory.create()).build()
}

fun provideOkHttpClient(): OkHttpClient{
  return OkHttpClient().newBuilder().build()
}

fun provideRandomPhotosApi(retrofit: Retrofit): GetPhotosService{
  return retrofit.create(GetPhotosService::class.java)
}