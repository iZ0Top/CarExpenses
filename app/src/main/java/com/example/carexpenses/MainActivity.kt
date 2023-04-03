package com.example.carexpenses

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.carexpenses.databinding.ActivityMainBinding
import com.example.carexpenses.utils.APP_ACTIVITY
import com.example.carexpenses.utils.TAG
import com.example.carexpenses.utils.showToast
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var mToolbar: Toolbar
    private lateinit var mNavController: NavController
    private lateinit var mNavHostFragment: NavHostFragment
    private lateinit var mBottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        APP_ACTIVITY = this

        mNavHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        mNavController = mNavHostFragment.navController

        mToolbar = binding.toolbar
        mToolbar.title = "toolbar title"
        setSupportActionBar(mToolbar)

        mBottomNavigationView = binding.bottomMenu

        mBottomNavigationView.setOnItemSelectedListener {
            when (it.itemId){
                R.id.bottom_btn_list -> {
                    APP_ACTIVITY.mNavController.navigate(R.id.fragmentList)
                    showToast("list")
            }
                R.id.bottom_btn_add -> {
                    APP_ACTIVITY.mNavController.navigate(R.id.fragmentAdd)
                    showToast("add")
                }
                R.id.bottom_btn_info -> {
                    APP_ACTIVITY.mNavController.navigate(R.id.fragmentInfo)
                    showToast("list")
                }
        }
            true
        }
    }

    override fun onStart() {
        super.onStart()


        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }
}
