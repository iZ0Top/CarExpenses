package com.example.carexpenses.database

import androidx.lifecycle.LiveData
import com.example.carexpenses.model.Car
import com.example.carexpenses.model.EventExpense
import com.example.carexpenses.model.EventRefueling
import com.example.carexpenses.utils.CURRENT_CAR

class RoomRepository(private val roomDao: RoomDao) {

     val allCars: LiveData<List<Car>>
        get() = roomDao.getAllCars()

     val allEventExpense: LiveData<List<EventExpense>>
        get() = roomDao.getAllEventsExpense(CURRENT_CAR)

     val allEventRefueling: LiveData<List<EventRefueling>>
        get() = roomDao.getAllEventsRefueling(CURRENT_CAR)

     suspend fun insertCar(car: Car, onSuccess: () -> Unit) {
        roomDao.insertCar(car)
    }

     suspend fun deleteCar(car: Car, onSuccess: () -> Unit) {
        roomDao.deleteCar(car)
    }

     suspend fun insertEventExpense(expense: EventExpense, onSuccess: () -> Unit) {
        roomDao.insertEventsExpense(expense)
    }

     suspend fun deleteEventExpense(expense: EventExpense, onSuccess: () -> Unit) {
        roomDao.deleteEventsExpense(expense)
    }

     suspend fun insertEventRefueling(refueling: EventRefueling, onSuccess: () -> Unit) {
        roomDao.insertEventsRefueling(refueling)
    }

     suspend fun deleteEventRefueling(refueling: EventRefueling, onSuccess: () -> Unit) {
        roomDao.deleteEventsRefueling(refueling)
    }
}