package com.batch.kmm_sample_app.androidApp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.batch.kmm_sample_app.shared.data.repository.TestRepository
import com.batch.kmm_sample_app.shared.data.usecase.SearchActressUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi

class MainViewModelFactory(
    private val testRepository: TestRepository,
    private val searchActressUseCase: SearchActressUseCase
) :
    ViewModelProvider.NewInstanceFactory() {
    @ExperimentalCoroutinesApi
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(testRepository, searchActressUseCase) as T
    }
}