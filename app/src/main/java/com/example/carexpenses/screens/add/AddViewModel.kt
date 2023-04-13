package com.example.carexpenses.screens.add

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.carexpenses.model.Event
import com.example.carexpenses.model.Expense
import com.example.carexpenses.utils.REPOSITORY
import com.example.carexpenses.utils.TAG
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddViewModel(application: Application): AndroidViewModel(application) {

    val currentExpenseList = MutableLiveData<List<Expense>>()
    private val list = mutableListOf<Expense>()

    fun setListToEdit(groupEvent: Event){

    }


    fun addToList(expense: Expense){
        list.add(expense)
        currentExpenseList.postValue(list)
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.insertExpense(expense) {
                viewModelScope.launch(Dispatchers.Main){
                }
            }
        }
    }

    fun dellFromList(expense: Expense){
        list.remove(expense)
        currentExpenseList.postValue(list)
        viewModelScope.launch(Dispatchers.IO){
            REPOSITORY.deleteExpense(expense){
                viewModelScope.launch(Dispatchers.Main){

                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "AddViewModel. onCleared")
    }

}