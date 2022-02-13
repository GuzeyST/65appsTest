package ru.guzeyst.a65appstest.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "Employees"
)
data class EmployeeEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Long,
    @ColumnInfo(name = "avatar_url")
    val avatarUrl: String,
    @ColumnInfo(name = "birthday")
    val birthday: String,
    @ColumnInfo(name = "f_name")
    val fName: String,
    @ColumnInfo(name = "l_name")
    val lName: String
)