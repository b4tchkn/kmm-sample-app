package com.batch.kmm_sample_app.shared.data.remote

import com.batch.kmm_sample_app.shared.data.model.SearchActressResponse

interface ActressDataSource {
    @Throws(Exception::class)
    suspend fun searchActress(searchedKeyWord: String): SearchActressResponse
}