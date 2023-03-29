package com.example.carexpenses.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.carexpenses.model.Car
import com.example.carexpenses.model.EventExpense
import com.example.carexpenses.model.EventRefueling


@Dao
interface RoomDao {

    @Query("SELECT * FROM table_car")
    fun getAllCars(): LiveData<List<Car>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCar(car: Car)

    @Delete
    suspend fun deleteCar(car: Car)

    @Query("SELECT * FROM table_event_refueling WHERE carId = :carId")
    fun getAllEventsRefueling(carId: String): LiveData<List<EventRefueling>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertEventsRefueling(refueling: EventRefueling)

    @Delete
    suspend fun deleteEventsRefueling(refueling: EventRefueling)

    @Query("SELECT * FROM table_event_expense WHERE carId = :carId")
    fun getAllEventsExpense(carId: String): LiveData<List<EventExpense>>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertEventsExpense(expense: EventExpense)
    @Delete
    suspend fun deleteEventsExpense(expense: EventExpense)
}