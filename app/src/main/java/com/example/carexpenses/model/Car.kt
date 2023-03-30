package com.example.carexpenses.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cars")
data class Car(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val brand: String,
    val model: String,
    val winCode: String,
    val odometer: Int,
    val purchaseDate: String,
    val fuelType: Int
)
