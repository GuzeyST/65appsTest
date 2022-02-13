package ru.guzeyst.a65appstest.di

import android.app.Application
import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.guzeyst.a65appstest.data.EmployeesSpecialtyRepositoryImpl
import ru.guzeyst.a65appstest.data.database.DatabaseDao
import ru.guzeyst.a65appstest.domain.EmployeesSpecialtyRepository
import ru.guzeyst.a65appstest.data.database.Database
import ru.guzeyst.a65appstest.data.database.source.DatabaseSource
import ru.guzeyst.a65appstest.data.database.source.DatabaseSourceImpl

@Module
interface DataModule {

    @Binds
    fun bindEmployeesSpecialtyRepository(impl: EmployeesSpecialtyRepositoryImpl): EmployeesSpecialtyRepository

    @Binds
    fun bindDatabaseSource(impl: DatabaseSourceImpl): DatabaseSource

    companion object{
        @Provides
        fun provideDao(application: Application): DatabaseDao{
            return Database.getInstance(application).databaseDao()
        }
    }
}