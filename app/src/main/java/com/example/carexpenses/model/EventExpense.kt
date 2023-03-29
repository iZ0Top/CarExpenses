package com.example.carexpenses.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_event_expense")
data class EventExpense(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val carId: Int = 0,
    val date: String = "",
    val odometer: Int = 0,
    val type: Int = 0,
    val name: String = "",
    val description: String = "",
    val partNum: String = "",
    val price: Int = 0,
    val quantity: Int = 0,
    )
