package com.batch.kmm_sample_app.shared.data.remote

import com.batch.kmm_sample_app.shared.data.model.SearchActressResponse
import kotlinx.coroutines.flow.Flow

interface ActressDataSource {
    @Throws(Exception::class)
    suspend fun searchActress(searchedKeyWord: String): Flow<SearchActressResponse>
}