package com.son.expensetracker.adapter

import androidx.recyclerview.widget.DiffUtil
import com.son.expensetracker.model.Expense

class ExpenseDiffItemCallback : DiffUtil.ItemCallback<Expense>() {
    override fun areItemsTheSame(oldItem: Expense, newItem: Expense): Boolean = (oldItem.id == newItem.id)

    override fun areContentsTheSame(oldItem: Expense, newItem: Expense): Boolean =
        (oldItem == newItem)
}