package ru.guzeyst.a65appstest.presentation.specialties.adapter

import androidx.recyclerview.widget.DiffUtil
import ru.guzeyst.a65appstest.domain.model.Employee

object EmployeesDiffCallBack: DiffUtil.ItemCallback<Employee>() {
    override fun areItemsTheSame(oldItem: Employee, newItem: Employee): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Employee, newItem: Employee): Boolean {
        return oldItem == newItem
    }
}