package ru.guzeyst.a65appstest.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

@Entity(
    tableName = "employee_specialty",
    primaryKeys = ["id_employee", "id_specialty"],
    indices = [
        Index("id_specialty")
    ],
    foreignKeys = [
        ForeignKey(
            entity = EmployeeEntity::class,
            parentColumns = ["id"],
            childColumns = ["id_employee"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = SpecialtyEntity::class,
            parentColumns = ["id"],
            childColumns = ["id_specialty"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ]
)
data class EmployeeSpecialtyEntity(
    @ColumnInfo(name = "id_employee")
    val idEmployee: Long,
    @ColumnInfo(name = "id_specialty")
    val idSpecialty: Long
)
