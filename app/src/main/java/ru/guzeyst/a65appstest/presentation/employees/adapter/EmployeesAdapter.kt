package ru.guzeyst.a65appstest.presentation.specialties.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.guzeyst.a65appstest.databinding.EmployeeItemShortBinding
import ru.guzeyst.a65appstest.databinding.SpecialtyItemBinding
import ru.guzeyst.a65appstest.domain.model.Employee
import ru.guzeyst.a65appstest.domain.model.Specialty

class EmployeesAdapter: ListAdapter<Employee, EmployeesAdapter.EmployeeViewHolder>(EmployeesDiffCallBack) {

    var clickListener: ((Employee) -> (Unit))? = null

    class EmployeeViewHolder(val binding: EmployeeItemShortBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val binding = EmployeeItemShortBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return EmployeeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        val item = getItem(position)
        with(holder.binding){
            this.tvFirstName.text = item.f_name
            this.tvLastName.text = item.l_name
            this.tvOld.text = item.id.toString()
            root.setOnClickListener { clickListener?.invoke(item) }
        }
    }

}