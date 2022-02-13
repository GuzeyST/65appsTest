package ru.guzeyst.a65appstest.data

import androidx.lifecycle.LiveData
import ru.guzeyst.a65appstest.data.database.entities.EmployeeEntity
import ru.guzeyst.a65appstest.data.database.entities.SpecialtyEntity
import ru.guzeyst.a65appstest.data.database.source.DatabaseSourceImpl
import ru.guzeyst.a65appstest.data.mapping.EntityFromDto
import ru.guzeyst.a65appstest.data.network.ApiFactory
import ru.guzeyst.a65appstest.domain.EmployeesSpecialtyRepository
import ru.guzeyst.a65appstest.domain.model.Employee
import ru.guzeyst.a65appstest.domain.model.EmployeeDto
import ru.guzeyst.a65appstest.domain.model.Specialty
import javax.inject.Inject

class EmployeesSpecialtyRepositoryImpl @Inject constructor(
    private val mapper: EntityFromDto,
    private val databaseSourceImpl: DatabaseSourceImpl
) : EmployeesSpecialtyRepository {

    override suspend fun loadResponse() {
        val apiService = ApiFactory.apiService
        try {
            val response = apiService.loadResponse()
            response.listEmployees?.let {
                parseResponse(it)
            }
        } catch (e: Exception) {
        }
    }

    override fun getListSpecialties(): LiveData<List<Specialty>> {
        return databaseSourceImpl.getListSpecialties()
    }

    override fun getEmployeesBySpecialty(id_specialty: Long): LiveData<List<Employee>>  {
        return databaseSourceImpl.getEmployeesBySpecialty(id_specialty)
    }

    override fun getEmployeeById() {
        TODO("Not yet implemented")
    }

    private suspend fun parseResponse(responseListEmployees: List<EmployeeDto>){
        val mapEmployeeSpecialty = mutableMapOf<EmployeeEntity, List<SpecialtyEntity>>()

        for(employee in responseListEmployees){
            val listSpecialty = mutableListOf<SpecialtyEntity>()
            val employeeEntity = mapper.employeeEntityFromEmployeeDto(employee)
            employee.specialtyDto?.let{listSp ->
                for(specialty in listSp){
                    val specialtyEntity = mapper.specialityEntityFromSpecialityDto(specialty)
                    listSpecialty.add(specialtyEntity)
                }
            }
            mapEmployeeSpecialty[employeeEntity] = listSpecialty
        }
        databaseSourceImpl.insertToDatabase(mapEmployeeSpecialty)
    }
}