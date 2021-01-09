package com.batch.kmm_sample_app.shared.data.repository

import com.batch.kmm_sample_app.shared.data.model.SearchActressResponse
import kotlinx.coroutines.flow.Flow

interface ActressRepository {
    suspend fun searchActress(searchedKeyWord: String): Flow<SearchActressResponse>
}