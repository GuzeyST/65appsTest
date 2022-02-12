package ru.guzeyst.a65appstest.domain.useCase

import ru.guzeyst.a65appstest.domain.EmployeesSpecialtyRepository

class getListSpecialties(private val repo: EmployeesSpecialtyRepository) {
    operator fun invoke() = repo.getListSpecialties()
}