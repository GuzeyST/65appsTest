package ru.guzeyst.a65appstest.data.mapping

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import ru.guzeyst.a65appstest.data.database.entities.EmployeeEntity
import ru.guzeyst.a65appstest.data.database.entities.SpecialtyEntity
import ru.guzeyst.a65appstest.domain.model.Employee
import ru.guzeyst.a65appstest.domain.model.Specialty
import javax.inject.Inject

class DomainModelFromEntity @Inject constructor(){
    fun specialtyFromSpecialtyEntity(toLiveData: LiveData<List<SpecialtyEntity>>): LiveData<List<Specialty>> {
        return Transformations.map(toLiveData){ list ->
            list.map {
                Specialty(it.name, it.specialty_id)
            }
        }
    }

    fun EmployeeFromEmployeeEntity(toLiveData: LiveData<List<EmployeeEntity>>): LiveData<List<Employee>> {
        return Transformations.map(toLiveData){ list ->
            list.map {
                Employee(
                    it.id,
                    it.avatarUrl ?: "",
                    it.birthday ?: "-",
                    it.fName ?: "",
                    it.lName ?: ""
                )
            }
        }
    }

}