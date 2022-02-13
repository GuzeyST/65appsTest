package ru.guzeyst.a65appstest.presentation.employees

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.guzeyst.a65appstest.domain.model.Employee
import ru.guzeyst.a65appstest.domain.useCase.GetEmployeesBySpecialty
import javax.inject.Inject

class EmpViewModel @Inject constructor(
    private val getEmployeesBySpecialty: GetEmployeesBySpecialty
) : ViewModel() {
    var listEmployees: LiveData<List<Employee>>? = null

    fun getList(id: Long) {
        listEmployees = getEmployeesBySpecialty.invoke(id)
    }
}
