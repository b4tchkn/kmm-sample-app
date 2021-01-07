package com.batch.kmm_sample_app.shared.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchActressResponse(
    @SerialName("request")
    val request: Request,
    @SerialName("result")
    val result: Result
) {
    @Serializable
    data class Request(
        @SerialName("parameters")
        val parameters: Parameters
    ) {
        @Serializable
        data class Parameters(
            @SerialName("api_id")
            val apiId: String,
            @SerialName("affiliate_id")
            val affiliateId: String,
            @SerialName("keyword")
            val keyword: String,
            @SerialName("bust")
            val bust: String,
            @SerialName("waist")
            val waist: String,
            @SerialName("hits")
            val hits: String,
            @SerialName("sort")
            val sort: String,
            @SerialName("output")
            val output: String
        )
    }

    @Serializable
    data class Result(
        @SerialName("status")
        val status: String,
        @SerialName("result_count")
        val resultCount: Int,
        @SerialName("total_count")
        val totalCount: String,
        @SerialName("first_position")
        val firstPosition: Int,
        @SerialName("actress")
        val actress: List<Actress>
    )
}