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
    private var _listEmployees = MutableLiveData<List<Employee>>()
    val listEmployees: LiveData<List<Employee>>
        get() = _listEmployees

    fun getList(id: Long) {
        _listEmployees.value = getEmployeesBySpecialty.invoke(id).value
    }
}
