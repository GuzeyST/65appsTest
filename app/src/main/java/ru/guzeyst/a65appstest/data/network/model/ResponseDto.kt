package ru.guzeyst.a65appstest.domain.model

import com.google.gson.annotations.SerializedName

data class ResponseDto(
    @SerializedName("response")
    val listEmployees: List<EmployeeDto>?
)