package com.example.carexpenses.model

import androidx.room.Entity
import java.util.Date

@Entity(tableName = "table_expense")
data class Expense (
    val id_expense: Int,
    val id_group: Int,
    val odometer: Int,
    val date: String,
    val name: String,
    val description: String,
    val partNumber: String,
    val amount: Int,
    val sum: Int
        )