package com.example.carexpenses.screens.add

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.carexpenses.model.Expense
import com.example.carexpenses.utils.TAG

class AddViewModel(application: Application): AndroidViewModel(application) {

    private var id_group = 0

    val currentExpenseList = MutableLiveData<List<Expense>>()

    fun setGroupToEdit(list: List<Expense>){
        currentExpenseList.postValue(list)
    }

    fun createNewGroup(){
        currentExpenseList.postValue(emptyList())
    }


    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "AddViewModel. onCleared")
    }

}