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

class DomainModelFromEntity @Inject constructor(){

    companion object {
        private const val FORMAT = "dd.MM.yyyy"
        private const val EMPTY_STRING = ""
        private const val DASH_STRING = "-"
    }

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
                    it.avatarUrl ?: EMPTY_STRING,
                    it.birthday ?: DASH_STRING,
                    it.fName ?: EMPTY_STRING,
                    it.lName ?: EMPTY_STRING,
                    it.birthday?.let {birthday -> parseAge(birthday) } ?: EMPTY_STRING
                )
            }
        }
    }

    private fun parseAge(birthday: String): String{
        if(birthday.isEmpty()) return EMPTY_STRING
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern(FORMAT)
        val startDate: LocalDate = LocalDate.parse(birthday, formatter)
        val endDate: LocalDate = LocalDate.now()
        val period: Period = Period.between(startDate, endDate)
        return "Возраст: ${period.getYears()} г."

    }

}