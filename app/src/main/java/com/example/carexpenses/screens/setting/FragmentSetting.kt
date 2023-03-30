package com.example.carexpenses.screens.setting
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.carexpenses.R
import com.example.carexpenses.databinding.FragmentSettingBinding

class FragmentSetting : Fragment() {

    private var _binding: FragmentSettingBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSettingBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onStart() {
        super.onStart()



    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}