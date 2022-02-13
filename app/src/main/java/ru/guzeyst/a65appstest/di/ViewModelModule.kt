package ru.guzeyst.a65appstest.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.guzeyst.a65appstest.presentation.employees.EmpViewModel
import ru.guzeyst.a65appstest.presentation.specialties.SpViewModel

@Module
interface ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(SpViewModel::class)
    fun bindSpViewModel(viewModel: SpViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(EmpViewModel::class)
    fun bindEmpViewModel(viewModel: EmpViewModel): ViewModel
}