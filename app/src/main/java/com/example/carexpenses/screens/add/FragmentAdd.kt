package com.example.carexpenses.screens.add
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentResultListener
import androidx.lifecycle.ViewModelProvider
import com.example.carexpenses.databinding.FragmentAddBinding
import com.example.carexpenses.model.Expense
import com.example.carexpenses.screens.dialog.DialogAddExpense
import com.example.carexpenses.utils.TAG
import com.google.android.material.floatingactionbutton.FloatingActionButton


class FragmentAdd : Fragment() {

    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!
    lateinit var mAddViewModel: AddViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAddBinding.inflate(inflater, container, false)
        return binding.root
    }



    override fun onStart() {
        super.onStart()
        mAddViewModel = ViewModelProvider(this).get(AddViewModel::class.java)

        binding.addFab.setOnClickListener {
            showDialog()
        }
        getResultFromDialog()
    }

    override fun onResume() {
        super.onResume()



    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun showDialog(){
        DialogAddExpense.showDialog(parentFragmentManager, null)
    }
    fun getResultFromDialog(){
        parentFragmentManager.setFragmentResultListener(DialogAddExpense.REQUEST_KEY, viewLifecycleOwner, FragmentResultListener { requestKey, result ->
            val e = result.getBundle(DialogAddExpense.RESPONSE_KEY)
            Log.d(TAG, "Dialog result: ${e.toString()}")
        })
    }
}