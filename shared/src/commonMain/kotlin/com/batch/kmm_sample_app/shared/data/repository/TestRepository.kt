package com.batch.kmm_sample_app.shared.data.repository

import com.batch.kmm_sample_app.shared.CFlow
import com.batch.kmm_sample_app.shared.data.model.SearchActressResponse
import com.batch.kmmsampleapp.shared.local.Launch

interface TestRepository {
    suspend fun getAllLaunches(): CFlow<List<Launch>>
    suspend fun searchActress(searchedKeyWord: String): CFlow<SearchActressResponse>
}