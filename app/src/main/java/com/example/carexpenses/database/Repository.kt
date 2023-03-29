package com.example.carexpenses.database

import androidx.lifecycle.LiveData
import com.example.carexpenses.model.Car
import com.example.carexpenses.model.EventExpense
import com.example.carexpenses.model.EventRefueling

interface Repository  {

    val allCars: LiveData<List<Car>>
    suspend fun insertCar(car: Car, onSuccess: () -> Unit)
    suspend fun deleteCar(car: Car, onSuccess: () -> Unit)

    val allEventExpense: LiveData<List<EventExpense>>
    suspend fun insertEventExpense(expense: EventExpense, onSuccess: () -> Unit)
    suspend fun deleteEventExpense(expense: EventExpense, onSuccess: () -> Unit)

    val allEventRefueling: LiveData<List<EventRefueling>>
    suspend fun insertEventRefueling(refueling: EventRefueling, onSuccess: () -> Unit)
    suspend fun deleteEventRefueling(refueling: EventRefueling, onSuccess: () -> Unit)
}