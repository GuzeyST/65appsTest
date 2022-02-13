package ru.guzeyst.a65appstest.presentation.specialties

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.guzeyst.a65appstest.domain.useCase.GetListSpecialties
import ru.guzeyst.a65appstest.domain.useCase.LoadResponse
import javax.inject.Inject

class SpViewModel @Inject constructor(
    private val loadResponse: LoadResponse,
    private val getListSpecialties: GetListSpecialties
) : ViewModel() {

    val listSpecialties = getListSpecialties.invoke()

    init {
        viewModelScope.launch {
            loadResponse.invoke()
        }
    }
}