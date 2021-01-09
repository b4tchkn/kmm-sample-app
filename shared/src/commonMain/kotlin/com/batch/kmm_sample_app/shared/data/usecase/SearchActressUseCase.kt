package com.batch.kmm_sample_app.shared.data.usecase

import com.batch.kmm_sample_app.shared.CFlow
import com.batch.kmm_sample_app.shared.data.model.SearchActressResponse
import com.batch.kmm_sample_app.shared.data.repository.ActressRepository
import com.batch.kmm_sample_app.shared.wrap

class SearchActressUseCase(private val actressRepository: ActressRepository) {
    suspend fun searchActress(searchedKeyWord: String): CFlow<SearchActressResponse> {
        return actressRepository.searchActress(searchedKeyWord).wrap()
    }
}