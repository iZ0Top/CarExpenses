package com.example.carexpenses.screens.list

import android.app.Application
import android.media.metrics.Event
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.carexpenses.database.room.RoomDatabase
import com.example.carexpenses.database.room.RoomRepository
import com.example.carexpenses.model.Expense
import com.example.carexpenses.utils.REPOSITORY


class ListViewModel(application: Application): AndroidViewModel(application) {

    private val listExpensesLD = REPOSITORY.getAllExpense
    private val listExpenses get() =  listExpensesLD.value
    val listEvents = MutableLiveData<List<Expense>>()


    fun initList(){
        if (listExpenses != null){

        }
    }

    fun groupEvents(){


    }
}