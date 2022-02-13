package ru.guzeyst.a65appstest.data.mapping

import ru.guzeyst.a65appstest.data.database.entities.EmployeeEntity
import ru.guzeyst.a65appstest.data.database.entities.SpecialtyEntity
import ru.guzeyst.a65appstest.domain.model.EmployeeDto
import ru.guzeyst.a65appstest.domain.model.SpecialtyDto
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import javax.inject.Inject

class EntityFromDto @Inject constructor(){

    companion object {
        private const val DEFAULT_ID = 0L
        private const val NEW_FORMAT = "dd.MM.yyyy"
        private const val OLD_FORMAT = "dd-MM-yyyy"
        private const val EMPTY_STRING = ""
    }

    fun employeeEntityFromEmployeeDto(toDto: EmployeeDto): EmployeeEntity {
        return EmployeeEntity(
            id = DEFAULT_ID,
            avatarUrl = toDto.avatr_url ?: EMPTY_STRING,
            birthday = parseData(toDto.birthday ?: EMPTY_STRING),
            fName = toFirstCharUpper(toDto.f_name ?: EMPTY_STRING),
            lName = toFirstCharUpper(toDto.l_name ?: EMPTY_STRING)
        )
    }

    fun specialityEntityFromSpecialityDto(toDto: SpecialtyDto): SpecialtyEntity {
        return SpecialtyEntity(
            specialty_id = toDto.specialty_id?.toLong() ?: DEFAULT_ID,
            name = toDto.name ?: EMPTY_STRING
        )
    }

    private fun toFirstCharUpper(str: String): String {
        return str.trim().lowercase().replaceFirstChar { it.uppercase() }
    }

    private fun parseData(dataStr: String): String {
        var result = EMPTY_STRING
        val newFormat = DateTimeFormatter.ofPattern(NEW_FORMAT)
        if (dataStr.isNotEmpty()) {
            result = try {
                LocalDate.parse(dataStr).format(newFormat)
            } catch (e: DateTimeParseException) {
                LocalDate.parse(
                    dataStr,
                    DateTimeFormatter.ofPattern(OLD_FORMAT)
                ).format(newFormat)
            }
        }
        return result
    }
}