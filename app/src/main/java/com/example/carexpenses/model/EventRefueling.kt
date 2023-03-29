package com.example.carexpenses.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_event_refueling")
data class EventRefueling(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val carId: Int = 0,
    val date: String = "",
    val odometer: Int = 0,
    val type: Int = 0,
    val fuelType: Int = 0,
    val volume: Int = 0,
    val price: Int = 0,
)
