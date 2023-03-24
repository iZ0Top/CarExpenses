package com.example.carexpenses.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "event_expenses")
data class EventExpense(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val date: String,
    val odometer: Int,
    val type: Int,
    val name: String = "",
    val description: String = "",
    val partNum: String = "",
    val price: Int,
    val quantity: Int = 0,
    )
