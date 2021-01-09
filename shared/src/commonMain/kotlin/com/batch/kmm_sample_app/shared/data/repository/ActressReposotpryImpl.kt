package com.batch.kmm_sample_app.shared.data.repository

import com.batch.kmm_sample_app.shared.data.model.SearchActressResponse
import com.batch.kmm_sample_app.shared.data.remote.ActressDataSource
import kotlinx.coroutines.flow.Flow

class ActressRepositoryImpl(private val actressDataSource: ActressDataSource) : ActressRepository {
    override suspend fun searchActress(searchedKeyWord: String): Flow<SearchActressResponse> =
        actressDataSource.searchActress(searchedKeyWord)
}