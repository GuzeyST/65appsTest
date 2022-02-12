package ru.guzeyst.a65appstest.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "Specialties"
)
data class SpecialtyEntity(
    @PrimaryKey(autoGenerate = false)
    val specialty_id: Int,
    val name: String
)