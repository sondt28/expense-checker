package com.son.expensetracker.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class Expense(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    var name: String = "",
    var cost: Float = 0F,
    @ColumnInfo(name = "date_created")
    var dateCreated: Date = Date()
)
