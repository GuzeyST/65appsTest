package ru.guzeyst.a65appstest.data.network

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import ru.guzeyst.a65appstest.domain.model.ResponseDto

interface ApiService {
    @GET("testTask.json")
    suspend fun loadResponse(): ResponseDto
}