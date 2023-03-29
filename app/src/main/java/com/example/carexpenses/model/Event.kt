package com.example.carexpenses.model

data class Event(
    val groupId: Int = 0,
    val date: String,
    val odometer: Int,
    val type: Int,
    val sum: Int,
    val listEventExpenses: List<EventExpense>?,
    val listEventRefueling: List<EventRefueling>?
    )