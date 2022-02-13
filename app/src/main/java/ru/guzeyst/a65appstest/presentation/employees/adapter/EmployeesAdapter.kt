package ru.guzeyst.a65appstest.presentation.specialties.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ru.guzeyst.a65appstest.R
import ru.guzeyst.a65appstest.databinding.EmployeeItemShortBinding
import ru.guzeyst.a65appstest.domain.model.Employee

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
            this.tvOld.text = item.age

            if (item.avatar_url.isEmpty()){
                this.imageView.setImageResource(R.drawable.ic_baseline_face_24)
            }else{
                Picasso.get()
                    .load(item.avatar_url)
                    .error(R.drawable.ic_baseline_face_24)
                    .placeholder(R.drawable.ic_baseline_face_24)
                    .into(this.imageView)
            }

            root.setOnClickListener { clickListener?.invoke(item) }
        }
    }

}