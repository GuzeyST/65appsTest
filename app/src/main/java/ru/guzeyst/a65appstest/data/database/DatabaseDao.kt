package ru.guzeyst.a65appstest.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.guzeyst.a65appstest.data.database.entities.EmployeeEntity
import ru.guzeyst.a65appstest.data.database.entities.EmployeeSpecialtyEntity
import ru.guzeyst.a65appstest.data.database.entities.SpecialtyEntity

@Dao
interface DatabaseDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertList(list: List<EmployeeEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEmployee(employeeEntity: EmployeeEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertListSpecialty(setSpecialtyEntity: Set<SpecialtyEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEmployeeSpecialty(employeeSpecialtyEntity: EmployeeSpecialtyEntity)

    @Query("DELETE FROM Employees")
    suspend fun deleteAll()

    @Query("SELECT * FROM Specialties")
    fun getAllSpecialties(): LiveData<List<SpecialtyEntity>>

    @Query("SELECT employees.* FROM employee_specialty LEFT JOIN employees ON id_employee == id WHERE employee_specialty.id_specialty = :id_specialty")
    fun getEmployeesBySpecialty(id_specialty: Long): LiveData<List<EmployeeEntity>>

    @Query("SELECT * FROM employees WHERE id=:id")
    fun getEmployeeById(id: Long): LiveData<EmployeeEntity>
}