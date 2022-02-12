package ru.guzeyst.a65appstest.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "Employees"
)
data class EmployeeEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val avatar_url: String,
    val birthday: String,
    val f_name: String,
    val l_name: String
)