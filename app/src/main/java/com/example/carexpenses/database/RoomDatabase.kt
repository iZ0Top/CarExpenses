package com.example.carexpenses.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import com.example.carexpenses.model.Car
import com.example.carexpenses.model.EventExpense
import com.example.carexpenses.model.EventRefueling

@Database(entities = [Car::class, EventExpense::class, EventRefueling::class], version = 1)
abstract class RoomDatabase: androidx.room.RoomDatabase() {
    abstract fun getRoomDao(): RoomDao

    companion object {
        @Volatile
        private var database: RoomDatabase? = null
        @Synchronized
        fun getInstance(context: Context): RoomDatabase{
            if (database == null){
                database = Room.databaseBuilder(context, RoomDatabase::class.java, name = "database").build()
                return database as RoomDatabase
            }
            else{

                return database as RoomDatabase
            }
        }
    }
}