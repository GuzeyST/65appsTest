package ru.guzeyst.a65appstest.presentation.employeeItem

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ru.guzeyst.a65appstest.domain.model.Employee
import ru.guzeyst.a65appstest.domain.useCase.GetEmployeeById
import javax.inject.Inject

class EmpItemViewModel @Inject constructor(
    private val getEmployeeById: GetEmployeeById
) : ViewModel(){

    var employees: LiveData<Employee>? = null

    fun getList(id: Long) {
        employees = getEmployeeById.invoke(id)
    }
}