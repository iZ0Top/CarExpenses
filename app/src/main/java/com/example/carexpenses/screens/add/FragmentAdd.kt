package com.example.carexpenses.screens.add
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentResultListener
import androidx.lifecycle.ViewModelProvider
import com.example.carexpenses.databinding.FragmentAddBinding
import com.example.carexpenses.model.Expense
import com.example.carexpenses.screens.dialog.DialogAddExpense
import com.google.android.material.floatingactionbutton.FloatingActionButton


class FragmentAdd : Fragment() {

    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!
    lateinit var mAddViewModel: AddViewModel

    private lateinit var fab: FloatingActionButton


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

        setupDialogListener()
        binding.addFab.setOnClickListener {
            val dialog = DialogAddExpense()
            dialog.show(parentFragmentManager, DialogAddExpense::class.java.simpleName)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupDialogListener(){
        parentFragmentManager.setFragmentResultListener(DialogAddExpense.REQUEST_KEY, viewLifecycleOwner, FragmentResultListener { _, result ->
            val expense = result.getSerializable(DialogAddExpense.RESPONSE_KEY)

        })

    }
}