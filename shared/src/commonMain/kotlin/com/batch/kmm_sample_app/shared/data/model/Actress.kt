package com.batch.kmm_sample_app.shared.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Actress(
    @SerialName("id")
    val id: String,
    @SerialName("name")
    val name: String,
    @SerialName("ruby")
    val ruby: String,
    @SerialName("bust")
    val bust: String,
    @SerialName("cup")
    val cup: String,
    @SerialName("waist")
    val waist: String,
    @SerialName("hip")
    val hip: String,
    @SerialName("height")
    val height: String,
    @SerialName("birthday")
    val birthday: String,
    @SerialName("blood_type")
    val bloodType: String,
    @SerialName("hobby")
    val hobby: String,
    @SerialName("prefecture")
    val prefecture: String,
    @SerialName("imageURL")
    val imageUrl: ImageUrl,
    @SerialName("listURL")
    val listURL: ListUrl

) {
    @Serializable
    data class ImageUrl(
        @SerialName("small")
        val small: String,
        @SerialName("large")
        val large: String
    )

    @Serializable
    data class ListUrl(
        @SerialName("digitral")
        val digital: String,
        @SerialName("monthly")
        val monthly: String,
        @SerialName("ppm")
        val ppm: String,
        @SerialName("mono")
        val mono: String,
        @SerialName("rental")
        val rental: String

    )
}