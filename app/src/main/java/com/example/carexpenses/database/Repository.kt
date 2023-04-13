package com.example.carexpenses.database

import androidx.lifecycle.LiveData
import com.example.carexpenses.model.Expense

interface Repository {

    val getAllExpense: LiveData<List<Expense>>

    val lastId: LiveData<Int>

    suspend fun insertExpense(expense: Expense, onSuccess:() -> Unit)

    suspend fun insertExpensesList(expensesList: List<Expense>, onSuccess: () -> Unit)

    suspend fun deleteExpense(expense: Expense, onSuccess: () -> Unit)
}