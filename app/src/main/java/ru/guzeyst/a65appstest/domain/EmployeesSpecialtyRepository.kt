package ru.guzeyst.a65appstest.domain

import androidx.lifecycle.LiveData
import ru.guzeyst.a65appstest.domain.model.Employee
import ru.guzeyst.a65appstest.domain.model.Specialty

interface EmployeesSpecialtyRepository {
    suspend fun loadResponse()
    fun getListSpecialties(): LiveData<List<Specialty>>
    fun getEmployeesBySpecialty(id_specialty: Long): LiveData<List<Employee>>
    fun getEmployeeById(id: Long): LiveData<Employee>
}