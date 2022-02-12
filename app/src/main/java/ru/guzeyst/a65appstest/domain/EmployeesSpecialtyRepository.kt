package ru.guzeyst.a65appstest.domain

interface EmployeesSpecialtyRepository {
    fun loadResponse()
    fun getListSpecialties()
    fun getEmployeesBySpecialty()
    fun getEmployeeById()
}