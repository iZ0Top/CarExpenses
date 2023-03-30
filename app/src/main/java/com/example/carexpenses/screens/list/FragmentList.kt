package com.example.carexpenses.screens.list
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.carexpenses.databinding.FragmentListBinding


class FragmentList : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
    override fun onStart() {
        super.onStart()

    }


    override fun onResume() {
        super.onResume()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}