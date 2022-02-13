package ru.guzeyst.a65appstest.domain.model

data class Employee(
    val id: Long,
    val avatar_url: String,
    val birthday: String,
    val f_name: String,
    val l_name: String,
    val age: String
)