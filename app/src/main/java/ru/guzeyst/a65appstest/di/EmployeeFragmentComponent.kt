package ru.guzeyst.a65appstest.di

import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent(
    modules = [
        DataModule::class,
        ViewModelModule::class
    ]
)
interface EmployeeFragmentComponent {


    @Subcomponent.Factory
    interface Factory{
        fun create(
            @BindsInstance id: Long = 0
        ): EmployeeFragmentComponent
    }
}