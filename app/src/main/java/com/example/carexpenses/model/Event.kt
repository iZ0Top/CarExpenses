package com.example.carexpenses.model

data class Event(
    val id_event: Int,
    val odometer: Int,
    val date: String,
    val sum: String,
    val expense: List<Expense>
        )