package com.example.carexpenses.utils

import androidx.lifecycle.LiveData
import com.example.carexpenses.model.Event
import com.example.carexpenses.model.EventExpense
import com.example.carexpenses.model.EventRefueling

class Calculate(eventExpense: EventExpense, eventRefueling: EventRefueling): LiveData<List<Event>>() {

    fun createList(expense: List<EventExpense>, refueling: List<EventRefueling>): List<Event>{

        var listEvent = mutableListOf<Event>()

        val mapExpense = expense.groupBy { it.id }
        val mapRefueling = refueling.groupBy { it.date }

        for (childMap in mapExpense){
            var childList = mutableListOf<EventExpense>()
            var date: String = ""
            var odometer: Int = 0
            var type  = 0
            var sum = 0
            for (eventExpense in childMap.value){
                date = eventExpense.date
                odometer = eventExpense.odometer
                sum += eventExpense.price
                childList.add(eventExpense)
            }
            listEvent.add(Event(0, date, odometer, type, sum, childList,null,))
        }
        for (childMap in mapRefueling){
            var childList = mutableListOf<EventRefueling>()
            var date: String = ""
            var odometer = 0
            var type = 0
            var sum = 0
            for (eventRefueling in childMap.key){

            }

        }
    }
}