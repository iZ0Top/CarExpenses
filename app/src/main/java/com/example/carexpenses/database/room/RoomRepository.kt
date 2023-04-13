package com.example.carexpenses.database.room

import androidx.lifecycle.LiveData
import com.example.carexpenses.database.Repository
import com.example.carexpenses.model.Expense

class RoomRepository(private val roomDao: RoomDao): Repository {

    override val getAllExpense: LiveData<List<Expense>>
        get() = roomDao.getAllExpense()

    override val lastId: LiveData<Int>
        get() = roomDao.getLastId()

    override suspend fun insertExpense(expense: Expense, onSuccess: () -> Unit) {
        roomDao.insertExpense(expense)
    }

    override suspend fun insertExpensesList(expensesList: List<Expense>, onSuccess: () -> Unit) {
        roomDao.insetExpensesList(expensesList)
    }

    override suspend fun deleteExpense(expense: Expense, onSuccess: () -> Unit) {
        roomDao.deleteExpense(expense)
    }
}