package ru.guzeyst.a65appstest.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import ru.guzeyst.a65appstest.presentation.specialties.SpecialtiesFragment

@Component(
    modules = [
        DataModule::class,
        ViewModelModule::class
    ]
)
interface ApplicationComponent {

    fun inject(fragment: SpecialtiesFragment)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }

}