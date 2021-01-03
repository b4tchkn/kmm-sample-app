package com.batch.kmm_sample_app.androidApp

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.batch.kmm_sample_app.shared.data.repository.TestRepository
import com.batch.kmmsampleapp.shared.local.Launch
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class MainViewModel(private val repository: TestRepository) : ViewModel() {

    private val _launches = MutableStateFlow<List<Launch>?>(null)
    val launches: StateFlow<List<Launch>?>
        get() = _launches
    private val _isLoading = MutableSharedFlow<Boolean>()
    val isLoading: SharedFlow<Boolean>
        get() = _isLoading

    fun getAllLaunches() {
        viewModelScope.launch {
            _isLoading.emit(true)
            kotlin.runCatching {
                repository.getAllLaunches()
            }.onSuccess {
                it.collect {
                    _launches.value = it
                }
            }.onFailure {
                Log.d("myapperror", it.toString())
            }
            _isLoading.emit(false)
        }
    }
}