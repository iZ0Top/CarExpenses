package com.example.carexpenses.utils

import android.content.Context
import android.content.SharedPreferences

object AppPreferences {

    private const val PREF_MANE = "preferences"
    private const val CHECK_REFUELING_STATUS = "refueling_status"

    private lateinit var mPreferences: SharedPreferences

    fun getPreferences(context: Context): SharedPreferences{
        mPreferences = context.getSharedPreferences(PREF_MANE, Context.MODE_PRIVATE)
        return mPreferences
    }


    fun setCheckRefuelingStatus(status: Boolean){
        mPreferences.edit().putBoolean(CHECK_REFUELING_STATUS, status).apply()
    }

    fun getCheckRefuelingStatus(): Boolean{
        return mPreferences.getBoolean(CHECK_REFUELING_STATUS, true)
    }
}