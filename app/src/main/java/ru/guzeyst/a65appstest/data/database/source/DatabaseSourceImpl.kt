package ru.guzeyst.a65appstest.data.database.source

import androidx.lifecycle.LiveData
import ru.guzeyst.a65appstest.data.database.DatabaseDao
import ru.guzeyst.a65appstest.data.database.entities.EmployeeEntity
import ru.guzeyst.a65appstest.data.database.entities.EmployeeSpecialtyEntity
import ru.guzeyst.a65appstest.data.database.entities.SpecialtyEntity
import ru.guzeyst.a65appstest.data.mapping.DomainModelFromEntity
import ru.guzeyst.a65appstest.domain.model.Employee
import ru.guzeyst.a65appstest.domain.model.Specialty
import javax.inject.Inject

class DatabaseSourceImpl @Inject constructor(
    private val dao: DatabaseDao,
    private val mapper: DomainModelFromEntity
) : DatabaseSource{

    override suspend fun insertToDatabase(
        mapResponse: Map<EmployeeEntity, List<SpecialtyEntity>>
    ) {
        dao.deleteAll()
        val setSpecialty = mapResponse.values.flatten().toSet()
        dao.insertListSpecialty(setSpecialty)
        for(elem in mapResponse){
            val idEmployee = dao.insertEmployee(elem.key)
            for (sp in elem.value){
                dao.insertEmployeeSpecialty(EmployeeSpecialtyEntity(idEmployee, sp.specialty_id))
            }
        }
    }

    override fun getListSpecialties(): LiveData<List<Specialty>> {
        return mapper.specialtyFromSpecialtyEntity(dao.getAllSpecialties())
    }

    override fun getEmployeesBySpecialty(id_specialty: Long): LiveData<List<Employee>> {
        return mapper.employeeListFromEmployeeEntityList(dao.getEmployeesBySpecialty(id_specialty))
    }

    override fun getEmployeeById(id: Long): LiveData<Employee> {
        return mapper.employeeFromEmployeeEntity(dao.getEmployeeById(id))
    }
}