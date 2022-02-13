package ru.guzeyst.a65appstest.domain.model

import com.google.gson.annotations.SerializedName

data class EmployeeDto(
    @SerializedName("avatr_url")
    val avatr_url: String?,
    @SerializedName("birthday")
    val birthday: String?,
    @SerializedName("f_name")
    val f_name: String?,
    @SerializedName("l_name")
    val l_name: String?,
    @SerializedName("specialty")
    val specialtyDto: List<SpecialtyDto>?
)