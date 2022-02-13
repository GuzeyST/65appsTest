package ru.guzeyst.a65appstest.data.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.guzeyst.a65appstest.data.database.entities.EmployeeEntity
import ru.guzeyst.a65appstest.data.database.entities.EmployeeSpecialtyEntity
import ru.guzeyst.a65appstest.data.database.entities.SpecialtyEntity

@androidx.room.Database(
    entities = [
        EmployeeEntity::class,
        SpecialtyEntity::class,
        EmployeeSpecialtyEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class Database : RoomDatabase() {
    companion object {
        private var db: Database? = null
        private const val DB_NAME = "Specialty.db"
        private val LOCK = Any()

        fun getInstance(context: Context): Database {
            db?.let { return it }
            synchronized(LOCK) {
                val instance = Room.databaseBuilder(
                    context,
                    Database::class.java,
                    DB_NAME
                ).build()
                db = instance
                return instance
            }
        }
    }

    abstract fun databaseDao(): DatabaseDao
}