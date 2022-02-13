package ru.guzeyst.a65appstest.domain.useCase

import ru.guzeyst.a65appstest.domain.EmployeesSpecialtyRepository
import javax.inject.Inject

class LoadResponse @Inject constructor(private val repo: EmployeesSpecialtyRepository) {
    suspend operator fun invoke() = repo.loadResponse()
}