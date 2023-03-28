package com.example.carexpenses.screens.setting

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.carexpenses.model.Car

class SettingViewModel(app: Application): AndroidViewModel(app) {

    private var carLD: LiveData<Car> = MutableLiveData<Car>()

    val carLiveData = MutableLiveData<Car>()

    fun  loadCars(){

    }

}