package com.example.advanced_examples.injection

import com.example.advanced_examples.PostsScreenModel
import org.koin.dsl.module

val postModule = module {
  factory {
    PostsScreenModel(get())
  }
}