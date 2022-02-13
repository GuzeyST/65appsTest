package ru.guzeyst.a65appstest.data.mapping

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import ru.guzeyst.a65appstest.data.database.entities.SpecialtyEntity
import ru.guzeyst.a65appstest.domain.model.Specialty
import javax.inject.Inject

class DomainModelFromEntity @Inject constructor(){
    fun specialtyEntityFromSpecialty(toLiveData: LiveData<List<SpecialtyEntity>>): LiveData<List<Specialty>> {
        return Transformations.map(toLiveData){
            it.map {
                Specialty(it.name, it.specialty_id)
            }
        }
    }
}