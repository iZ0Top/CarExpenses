package com.example.carexpenses.utils

import android.content.Context
import com.example.carexpenses.MainActivity
import com.example.carexpenses.database.Repository
import com.example.carexpenses.database.RoomRepository

//Константа для доступу до контектсту
lateinit var APP_ACTIVITY: MainActivity
lateinit var REPOSITORY: Repository
lateinit var ROOM_REPOSITORY: RoomRepository

lateinit var CURRENT_CAR: String

const val TYPE_EXPENSE = 0
const val TYPE_REFUELING = 1
const val DATABASE_NAME = "database_name"


const val TAG = "log"