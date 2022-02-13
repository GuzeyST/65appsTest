package ru.guzeyst.a65appstest.presentation.specialties.adapter

import androidx.recyclerview.widget.DiffUtil
import ru.guzeyst.a65appstest.domain.model.Specialty

object SpecialtiesDiffCallBack: DiffUtil.ItemCallback<Specialty>() {
    override fun areItemsTheSame(oldItem: Specialty, newItem: Specialty): Boolean {
        return oldItem.specialty_id == newItem.specialty_id
    }

    override fun areContentsTheSame(oldItem: Specialty, newItem: Specialty): Boolean {
        return oldItem == newItem
    }
}