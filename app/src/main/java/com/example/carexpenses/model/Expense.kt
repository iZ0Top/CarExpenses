package com.example.carexpenses.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_expense")
data class Expense (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_expense") val id_expense: Int,
    @ColumnInfo(name = "id_group")val id_group: Int,
    @ColumnInfo(name = "odometer")val odometer: Int,
    @ColumnInfo(name = "date")val date: String,
    @ColumnInfo(name = "name")val name: String,
    @ColumnInfo(name = "description")val description: String,
    @ColumnInfo(name = "part_number")val part_number: String,
    @ColumnInfo(name = "amount")val amount: Int,
    @ColumnInfo(name = "sum")val sum: Int
        )
