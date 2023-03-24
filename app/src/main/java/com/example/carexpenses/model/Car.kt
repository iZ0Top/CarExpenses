package com.example.carexpenses.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cars")
data class Car(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val brand: String,
    val model: String,
    val winCode: String,
    val productionDade: String,
    val purchaseDate: String,
    val engineCapacity: Int,
    val fuelType: Int,
    val odometer: Int
    )