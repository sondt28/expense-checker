package com.son.expensetracker.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.son.expensetracker.adapter.ExpenseItemAdapter
import com.son.expensetracker.dao.AppDatabase
import com.son.expensetracker.databinding.FragmentExpenseBinding
import com.son.expensetracker.viewmodels.ExpenseViewModel
import com.son.expensetracker.viewmodels.ExpenseViewModelFactory

class ExpenseFragment : Fragment() {
    private var _binding: FragmentExpenseBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentExpenseBinding.inflate(inflater, container, false)
        val view = binding.root

        val application = requireNotNull(this.activity).application
        val dao = AppDatabase.getInstance(application).expenseDao()
        val expenseViewModelFactory = ExpenseViewModelFactory(dao)
        val expenseViewModel =
            ViewModelProvider(this, expenseViewModelFactory).get(ExpenseViewModel::class.java)

        binding.expenseViewModel = expenseViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        handlerExpenseItemAdaper(expenseViewModel)

        return view
    }

    private fun handlerExpenseItemAdaper(expenseViewModel: ExpenseViewModel) {
        val adapter = ExpenseItemAdapter()
        binding.rcExpenses.adapter = adapter

        expenseViewModel.expenses.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}