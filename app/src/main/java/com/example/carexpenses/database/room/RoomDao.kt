package com.example.carexpenses.database.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.carexpenses.model.Expense

@Dao
interface RoomDao {

    @Query("SELECT * FROM table_expense")
    fun getAllExpense(): LiveData<List<Expense>>

    @Query("SELECT MAX(id_expense) FROM table_expense")
    fun getLastId(): LiveData<Int>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertExpense(expense: Expense)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insetExpensesList(expensesList: List<Expense>)

    @Delete
    suspend fun deleteExpense(expense: Expense)


}