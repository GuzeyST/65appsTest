package ru.guzeyst.a65appstest.domain

interface EmployeesSpecialtyRepository {
    fun loadResponse(): Boolean
    fun getListSpecialties()
    fun getEmployeesBySpecialty()
    fun getEmployeeById()
}