package com.son.expensetracker.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.son.expensetracker.model.Expense

@Dao
interface ExpenseDao {

    @Query("SELECT * FROM expense ORDER BY date_created DESC")
    fun getAll(): LiveData<List<Expense>>

    @Insert
    suspend fun insert(expense: Expense)
}