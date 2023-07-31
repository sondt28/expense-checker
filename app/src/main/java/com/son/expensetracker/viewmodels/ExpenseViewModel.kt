package com.son.expensetracker.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.son.expensetracker.dao.ExpenseDao
import com.son.expensetracker.model.Expense
import kotlinx.coroutines.launch
import java.util.Date

class ExpenseViewModel(val dao: ExpenseDao) : ViewModel() {
    val expenses = dao.getAll()

    var expenseName = MutableLiveData<String>()
    var expenseCost = MutableLiveData<String>()

    fun addExpense() {
        viewModelScope.launch {
            if (!expenseName.value.isNullOrBlank() && !expenseCost.value.isNullOrBlank()) {
                val expense = Expense()
                expense.cost = expenseCost.value!!.toFloat()
                expense.name = expenseName.value!!
                expense.dateCreated = Date()

                dao.insert(expense)

                expenseName.value = ""
                expenseCost.value = ""
            }
        }
    }
}