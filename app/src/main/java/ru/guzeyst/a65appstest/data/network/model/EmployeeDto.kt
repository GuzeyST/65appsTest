package ru.guzeyst.a65appstest.domain.model

import com.google.gson.annotations.SerializedName

data class EmployeeDto(
    val avatr_url: String?,
    val birthday: String?,
    val f_name: String?,
    val l_name: String?,
    @SerializedName("specialty")
    val specialtyDto: List<SpecialtyDto>?
)