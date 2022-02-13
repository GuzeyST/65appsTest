package ru.guzeyst.a65appstest.presentation.specialties.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.guzeyst.a65appstest.databinding.SpecialtyItemBinding
import ru.guzeyst.a65appstest.domain.model.Specialty

class SpecialtiesAdapter: ListAdapter<Specialty, SpecialtiesAdapter.SpecialtiesViewHolder>(SpecialtiesDiffCallBack) {

    var clickListener: ((Specialty) -> (Unit))? = null

    class SpecialtiesViewHolder(val binding: SpecialtyItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecialtiesViewHolder {
        val binding = SpecialtyItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return SpecialtiesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SpecialtiesViewHolder, position: Int) {
        val item = getItem(position)
        with(holder.binding){
            this.tvLabelSpecialty.text = item.name
            root.setOnClickListener { clickListener?.invoke(item) }
        }
    }

}