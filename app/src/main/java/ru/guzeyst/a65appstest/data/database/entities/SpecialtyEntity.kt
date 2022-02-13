package ru.guzeyst.a65appstest.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "Specialties"
)
data class SpecialtyEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val specialty_id: Long,
    val name: String
)