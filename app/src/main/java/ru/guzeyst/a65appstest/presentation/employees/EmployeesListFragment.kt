package ru.guzeyst.a65appstest.presentation.employees

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import ru.guzeyst.a65appstest.databinding.FragmentEmployeesListBinding
import ru.guzeyst.a65appstest.presentation.EmployeeApp
import ru.guzeyst.a65appstest.presentation.ViewModelFactory
import ru.guzeyst.a65appstest.presentation.specialties.SpecialtiesFragmentDirections
import ru.guzeyst.a65appstest.presentation.specialties.adapter.EmployeesAdapter
import javax.inject.Inject


class EmployeesListFragment : Fragment() {

    private val args by navArgs<EmployeesListFragmentArgs>()

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel by lazy { ViewModelProvider(
        this,
        viewModelFactory
    )[EmpViewModel::class.java] }

    private val component by lazy {
        (requireActivity().application as EmployeeApp).component
    }

    private val adapter by lazy { EmployeesAdapter() }

    private var _binding: FragmentEmployeesListBinding? = null
    private val binding: FragmentEmployeesListBinding
        get() = _binding ?: throw RuntimeException("Employees list fragment binding is null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEmployeesListBinding.inflate(inflater, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        setObserve()
    }


    private fun initRecyclerView(){
        val recyclerView = binding.rvEmployeesList
        adapter.clickListener = {
            findNavController().navigate(EmployeesListFragmentDirections.actionEmployeesListFragmentToEmployeeItemFragment())
        }
        recyclerView.adapter = adapter
    }

    private fun setObserve(){
        viewModel.getList(args.idSpecialty)
        viewModel.listEmployees.observe(this,{
            adapter.submitList(it)
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