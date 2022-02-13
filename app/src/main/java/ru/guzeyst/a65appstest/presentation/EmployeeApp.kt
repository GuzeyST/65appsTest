package ru.guzeyst.a65appstest.presentation

import android.app.Application
import ru.guzeyst.a65appstest.di.DaggerApplicationComponent

class EmployeeApp: Application() {
    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}