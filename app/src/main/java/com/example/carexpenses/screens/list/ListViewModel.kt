package com.example.carexpenses.screens.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import com.example.carexpenses.database.Repository
import com.example.carexpenses.database.RoomDatabase
import com.example.carexpenses.database.RoomRepository
import com.example.carexpenses.model.Car
import com.example.carexpenses.model.Event
import com.example.carexpenses.model.EventExpense
import com.example.carexpenses.model.EventRefueling
import com.example.carexpenses.utils.Calculate
import com.example.carexpenses.utils.REPOSITORY
import com.example.carexpenses.utils.ROOM_REPOSITORY

class ListViewModel(application: Application): AndroidViewModel(application) {

    private val mContext = application
    lateinit var allCars: LiveData<List<Car>>
    lateinit var allEventExpense: LiveData<List<EventExpense>>
    lateinit var allEventRefueling: LiveData<List<EventRefueling>>

    fun initDatabase(){
        val dao = RoomDatabase.getInstance(mContext).getRoomDao()
        ROOM_REPOSITORY = RoomRepository(dao)
    }
    fun getCarList(){
        allCars = ROOM_REPOSITORY.allCars
    }
    fun getEvents(){
        allEventExpense = ROOM_REPOSITORY.allEventExpense
        allEventRefueling = ROOM_REPOSITORY.allEventRefueling
    }









}