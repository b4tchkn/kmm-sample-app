package com.batch.kmm_sample_app.androidApp

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.batch.kmm_sample_app.shared.data.model.Actress
import com.batch.kmm_sample_app.shared.data.repository.TestRepository
import com.batch.kmm_sample_app.shared.data.usecase.SearchActressUseCase
import com.batch.kmmsampleapp.shared.local.Launch
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class MainViewModel(
    private val testRepository: TestRepository,
    private val searchActressUseCase: SearchActressUseCase
) : ViewModel() {

    private val _launches = MutableStateFlow<List<Launch>>(listOf())
    val launches: StateFlow<List<Launch>>
        get() = _launches
    private val _isLoading = MutableStateFlow<Boolean>(false)
    val isLoading: StateFlow<Boolean>
        get() = _isLoading
    private val _actresses = MutableStateFlow<List<Actress>>(listOf())
    val actresses: StateFlow<List<Actress>>
        get() = _actresses

    fun getAllLaunches() {
        viewModelScope.launch {
            _isLoading.emit(true)
            kotlin.runCatching {
                testRepository.getAllLaunches()
            }.onSuccess {
                it.collect { launches ->
                    _launches.value = launches
                }
            }.onFailure {
                Log.d("myapperror", it.toString())
            }
            _isLoading.emit(false)
        }
    }

    fun searchActress(searchedKeyWord: String) {
        viewModelScope.launch {
            _isLoading.emit(true)
            kotlin.runCatching {
                searchActressUseCase.searchActress(searchedKeyWord)
            }.onSuccess {
                it.collect { response ->
                    _actresses.value = response.result.actress
                }
            }.onFailure {
                Log.d("myapperror", it.toString())
            }
            _isLoading.emit(false)
        }
    }
}