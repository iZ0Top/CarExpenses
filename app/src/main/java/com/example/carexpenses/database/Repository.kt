package com.example.carexpenses.database

import androidx.lifecycle.LiveData
import com.example.carexpenses.model.Expense

interface Repository {

    val getAllExpense: LiveData<List<Expense>>
    //suspend fun getAllExpense(): LiveData<List<Expense>>
    suspend fun insertExpense(expense: Expense, onSuccess:() -> Unit)
    suspend fun deleteExpense(expense: Expense, onSuccess: () -> Unit)
}