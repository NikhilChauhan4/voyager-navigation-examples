package com.example.feature_random_photos.viewmodel

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalSavedStateRegistryOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import com.example.data.repository.FetchPhotosRepo
import com.example.domain.model.PhotosResponseItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.koin.androidx.compose.getComposeViewModelOwner
import org.koin.androidx.viewmodel.ViewModelOwner
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.annotation.KoinInternalApi
import org.koin.core.context.GlobalContext
import org.koin.core.parameter.ParametersDefinition
import org.koin.core.qualifier.Qualifier
import org.koin.core.scope.Scope
import org.koin.dsl.module

class PhotosViewModel(private val fetchPhotosRepo: FetchPhotosRepo): ViewModel() {
  val photosResponse: Flow<List<PhotosResponseItem>>
  get() = flow {
    emit(fetchPhotosRepo.fetchPhotos())
  }
}

val viewModelModule = module {
   viewModel {
     PhotosViewModel(get())
   }
}

@OptIn(KoinInternalApi::class)
@Composable
inline fun <reified T : ViewModel> getViewModel(
  qualifier: Qualifier? = null,
  owner: ViewModelOwner = getComposeViewModelOwner(),
  scope: Scope = GlobalContext.get().scopeRegistry.rootScope,
  noinline parameters: ParametersDefinition? = null,
){

}

@Composable
fun getComposeViewModelOwner(): ViewModelOwner {
  return ViewModelOwner.from(
      LocalViewModelStoreOwner.current!!,
      LocalSavedStateRegistryOwner.current
  )
}