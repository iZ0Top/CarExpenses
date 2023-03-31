package com.example.carexpenses.database.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.carexpenses.model.Expense

@Dao
interface RoomDao {

    @Query("SELECT * FROM table_expense")
    fun getAllExpense(): LiveData<List<Expense>>


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertExpense(expense: Expense)

    @Delete
    suspend fun deleteExpense(expense: Expense)


}