package ru.guzeyst.a65appstest.domain.useCase

import ru.guzeyst.a65appstest.domain.EmployeesSpecialtyRepository
import javax.inject.Inject

class GetListSpecialties @Inject constructor(private val repo: EmployeesSpecialtyRepository) {
    operator fun invoke() = repo.getListSpecialties()
}