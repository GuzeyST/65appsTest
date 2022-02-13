package ru.guzeyst.a65appstest.presentation.employees

import androidx.lifecycle.ViewModel
import ru.guzeyst.a65appstest.domain.useCase.GetEmployeesBySpecialty
import javax.inject.Inject

class EmpViewModel @Inject constructor(
    getEmployeesBySpecialty: GetEmployeesBySpecialty
) : ViewModel() {
    val listEmployees = getEmployeesBySpecialty.invoke(101L)

}
