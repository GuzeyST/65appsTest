package ru.guzeyst.a65appstest.domain.model

import com.google.gson.annotations.SerializedName

data class SpecialtyDto(
    @SerializedName("name")
    val name: String?,
    @SerializedName("specialty_id")
    val specialty_id: Int?
)