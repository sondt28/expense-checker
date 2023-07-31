package com.son.expensetracker.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.son.expensetracker.databinding.ItemExpenseBinding
import com.son.expensetracker.model.Expense
import java.text.DateFormat

class ExpenseItemAdapter :
    ListAdapter<Expense, ExpenseItemAdapter.ExpenseItemViewHolder>(ExpenseDiffItemCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseItemViewHolder {
        val binding = ItemExpenseBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ExpenseItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ExpenseItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class ExpenseItemViewHolder(val binding: ItemExpenseBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Expense) {
            binding.expense = item
        }
    }
}