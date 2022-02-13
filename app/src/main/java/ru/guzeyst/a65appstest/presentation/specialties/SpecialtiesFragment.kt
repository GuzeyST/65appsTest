package ru.guzeyst.a65appstest.presentation.specialties

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import ru.guzeyst.a65appstest.databinding.FragmentSpecialtiesBinding
import ru.guzeyst.a65appstest.presentation.EmployeeApp
import ru.guzeyst.a65appstest.presentation.ViewModelFactory
import ru.guzeyst.a65appstest.presentation.specialties.adapter.SpecialtiesAdapter
import javax.inject.Inject

class SpecialtiesFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel by lazy { ViewModelProvider(
        this,
        viewModelFactory
    )[SpViewModel::class.java] }

    private val component by lazy {
        (requireActivity().application as EmployeeApp).component
    }

    private var _binding: FragmentSpecialtiesBinding? = null
    private val binding: FragmentSpecialtiesBinding
        get() = _binding ?: throw RuntimeException("Specialties fragment binding is null")

    private val adapter by lazy { SpecialtiesAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSpecialtiesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        setObserve()
    }

    private fun initRecyclerView(){
        val recyclerView = binding.rvSpecialties
        adapter.clickListener = {
            findNavController().navigate(SpecialtiesFragmentDirections.actionSpecialtiesFragmentToEmployeesListFragment(it.specialty_id))
        }
        recyclerView.adapter = adapter
    }

    private fun setObserve(){
        viewModel.listSpecialties.observe(this,{
            adapter.submitList(it)
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}