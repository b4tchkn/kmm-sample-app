package com.batch.kmm_sample_app.shared.data.remote

import com.batch.kmm_sample_app.shared.Constants
import com.batch.kmm_sample_app.shared.data.model.SearchActressResponse
import io.ktor.client.*
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.json.Json

class ActressDataSourceImpl : ActressDataSource {
    private val dmmApiClient = HttpClient {
        install(JsonFeature) {
            val json = Json {
                ignoreUnknownKeys = true
                isLenient = true
            }
            serializer = KotlinxSerializer(json)
        }
    }

    @Throws(Exception::class)
    override suspend fun searchActress(searchedKeyWord: String): Flow<SearchActressResponse> {
        return flow {
            emit(
                dmmApiClient.get {
                    url(Constants.DMM_ENDPOINT)
                    parameter("api_id", Constants.API_ID)
                    parameter("affiliate_id", Constants.AFFILIATE_ID)
                    parameter("keyword", searchedKeyWord)
                }
            )
        }
    }
}