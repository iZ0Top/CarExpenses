package com.example.carexpenses.utils

import androidx.lifecycle.LiveData
import com.example.carexpenses.model.Event
import com.example.carexpenses.model.EventExpense
import com.example.carexpenses.model.EventRefueling

class Calculate(eventExpense: EventExpense, eventRefueling: EventRefueling): LiveData<List<Event>>() {

    fun createList(expense: List<EventExpense>, refueling: List<EventRefueling>): List<Event>{

        var listEvent = mutableListOf<Event>()

        val listExpense = expense.groupBy { it.id }
        val listRefueling = refueling.groupBy { it.date }

        for (childList in listExpense){
            var date: String = ""
            var odometer: Int = 0
            var type  = 0
            var sum = 0
            for (ex in childList.value){
                date = ex.date
                odometer = ex.odometer
                sum += ex.price
            }
            listEvent.add(Event(0, date, odometer, type, sum, childList, ))
        }
    }
}