package com.batch.kmm_sample_app.shared.data.repository

import com.batch.kmm_sample_app.shared.data.model.SearchActressResponse
import com.batch.kmmsampleapp.shared.local.Launch
import kotlinx.coroutines.flow.Flow

interface TestRepository {
    suspend fun getAllLaunches(): Flow<List<Launch>>
    suspend fun searchActress(searchedKeyWord: String): Flow<SearchActressResponse>
}