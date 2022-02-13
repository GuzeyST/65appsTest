package ru.guzeyst.a65appstest.data.database.source

import androidx.lifecycle.LiveData
import ru.guzeyst.a65appstest.data.database.entities.EmployeeEntity
import ru.guzeyst.a65appstest.data.database.entities.SpecialtyEntity
import ru.guzeyst.a65appstest.domain.model.Employee
import ru.guzeyst.a65appstest.domain.model.Specialty

interface DatabaseSource {
    suspend fun insertToDatabase(
        mapResponse: Map<EmployeeEntity, List<SpecialtyEntity>>
    )

    fun getListSpecialties(): LiveData<List<Specialty>>

    fun getEmployeesBySpecialty(id_specialty: Long): LiveData<List<Employee>>
}