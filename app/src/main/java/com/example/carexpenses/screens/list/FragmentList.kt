package com.example.carexpenses.screens.list
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.carexpenses.adapters.AdapterEvent
import com.example.carexpenses.databinding.FragmentListBinding
import com.example.carexpenses.utils.TAG


class FragmentList : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!
    private lateinit var mListViewModel: ListViewModel

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: AdapterEvent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
    override fun onStart() {
        super.onStart()

        mListViewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        mListViewModel.initDatabase(){
            Log.d(TAG, "mListViewModel.initDatabase CallBack")
        }

        mAdapter = AdapterEvent()

        mRecyclerView = binding.recyclerView
        mRecyclerView.adapter = mAdapter


    }


    override fun onResume() {
        super.onResume()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}