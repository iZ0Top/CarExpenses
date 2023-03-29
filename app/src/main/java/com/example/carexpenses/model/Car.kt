package com.example.carexpenses.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_car")
data class Car(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val brand: String = "",
    val model: String = "",
    val winCode: String = "",
    val productionDade: String = "",
    val purchaseDate: String = "",
    val engineCapacity: Int = 0,
    val fuelType: Int = 0,
    val odometer: Int = 0
    )