package ru.guzeyst.a65appstest.presentation.employeeItem

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.squareup.picasso.Picasso
import ru.guzeyst.a65appstest.R
import ru.guzeyst.a65appstest.databinding.FragmentEmployeeItemBinding
import ru.guzeyst.a65appstest.presentation.EmployeeApp
import ru.guzeyst.a65appstest.presentation.ViewModelFactory
import javax.inject.Inject


class EmployeeItemFragment : Fragment() {
    private val args by navArgs<EmployeeItemFragmentArgs>()

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel by lazy {
        ViewModelProvider(
            this,
            viewModelFactory
        )[EmpItemViewModel::class.java]
    }

    private val component by lazy {
        (requireActivity().application as EmployeeApp).component
    }

    private var _binding: FragmentEmployeeItemBinding? = null
    private val binding: FragmentEmployeeItemBinding
        get() = _binding ?: throw RuntimeException("Employees item fragment binding is null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEmployeeItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObserve()
    }


    private fun setObserve() {
        viewModel.getList(args.idEmployee)
        viewModel.employees?.observe(this, {
            with(binding){
                tvName.text = it.f_name
                tvLastName.text = it.l_name
                tvBirthday.text = it.birthday
                tvOld.text = it.age
                tvSpecialty.text = args.specialty

                if (it.avatar_url.isEmpty()){
                    ivAvatar.setImageResource(R.drawable.ic_baseline_face_24)
                }else{
                    Picasso.get()
                        .load(it.avatar_url)
                        .error(R.drawable.ic_baseline_face_24)
                        .placeholder(R.drawable.ic_baseline_face_24)
                        .into(ivAvatar)
                }
            }
        })
    }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}