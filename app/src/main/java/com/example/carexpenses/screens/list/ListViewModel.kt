package com.example.carexpenses.screens.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.carexpenses.database.room.RoomDatabase
import com.example.carexpenses.database.room.RoomRepository
import com.example.carexpenses.utils.REPOSITORY


class ListViewModel(application: Application): AndroidViewModel(application) {


    private val mContext = application

    fun initDatabase(onSuccess:() -> Unit){
        val dao = RoomDatabase.getInstance(mContext).getRoomDao()
        REPOSITORY = RoomRepository(dao)
        onSuccess()
    }
}