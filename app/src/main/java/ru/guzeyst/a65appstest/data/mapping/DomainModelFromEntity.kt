package ru.guzeyst.a65appstest.data.mapping

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import ru.guzeyst.a65appstest.data.database.entities.EmployeeEntity
import ru.guzeyst.a65appstest.data.database.entities.SpecialtyEntity
import ru.guzeyst.a65appstest.domain.model.Employee
import ru.guzeyst.a65appstest.domain.model.Specialty
import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter
import javax.inject.Inject

class DomainModelFromEntity @Inject constructor() {

    companion object {
        private const val FORMAT = "dd.MM.yyyy"
        private const val EMPTY_STRING = ""
        private const val DASH_STRING = "-"
    }

    fun specialtyFromSpecialtyEntity(toLiveData: LiveData<List<SpecialtyEntity>>): LiveData<List<Specialty>> {
        return Transformations.map(toLiveData) { list ->
            list.map {
                Specialty(it.name, it.specialty_id)
            }
        }
    }

    fun employeeListFromEmployeeEntityList(toLiveData: LiveData<List<EmployeeEntity>>): LiveData<List<Employee>> {
        return Transformations.map(toLiveData) { list ->
            list.map {
                getEmployee(it)
            }
        }
    }

    fun employeeFromEmployeeEntity(toEmployee: LiveData<EmployeeEntity>): LiveData<Employee> {
        return Transformations.map(toEmployee) {
            getEmployee(it)
        }
    }

    private fun getEmployee(toEmp: EmployeeEntity): Employee{
        return Employee(
            toEmp.id,
            toEmp.avatarUrl ?: EMPTY_STRING,
            toEmp.birthday?.let{ getBirthday(toEmp.birthday) } ?: DASH_STRING,
            toEmp.fName ?: EMPTY_STRING,
            toEmp.lName ?: EMPTY_STRING,
            toEmp.birthday?.let { birthday -> parseAge(birthday) } ?: DASH_STRING
        )
    }

    private fun getBirthday(birthday: String): String {
        if(birthday.isEmpty()) return DASH_STRING
        return birthday
    }

    private fun parseAge(birthday: String): String {
        if (birthday.isEmpty()) return DASH_STRING
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern(FORMAT)
        val startDate: LocalDate = LocalDate.parse(birthday, formatter)
        val endDate: LocalDate = LocalDate.now()
        val period: Period = Period.between(startDate, endDate)
        return "Возраст: ${period.years} г."

    }

}