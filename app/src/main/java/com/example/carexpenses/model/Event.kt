package com.example.carexpenses.model

data class Event (
    val id: Int = 0,
    val date: String,
    val odometer: Int,
    val type: Int,
    val sum: Int,
    val listEventExpenses: List<EventExpense> = emptyList(),
    val listEventRefueling: List<EventRefueling> = emptyList()
    )