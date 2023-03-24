package com.example.carexpenses.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "event_refueling")
data class EventRefueling(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val date: String,
    val odometer: Int,
    val type: Int,
    val fuelType: Int,
    val volume: Int,
    val price: Int,
)
