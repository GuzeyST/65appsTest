package ru.guzeyst.a65appstest.domain.useCase

import ru.guzeyst.a65appstest.domain.EmployeesSpecialtyRepository
import javax.inject.Inject

class GetEmployeesBySpecialty @Inject constructor(private val repo: EmployeesSpecialtyRepository) {
    operator fun invoke(idSpecialty: Long) = repo.getEmployeesBySpecialty(idSpecialty)
}