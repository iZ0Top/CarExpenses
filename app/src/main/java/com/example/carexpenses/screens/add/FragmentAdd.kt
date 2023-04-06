package com.example.carexpenses.screens.add
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.carexpenses.databinding.FragmentAddBinding
import com.example.carexpenses.model.Expense
import com.example.carexpenses.screens.dialog.DialogAddExpense
import com.example.carexpenses.utils.TAG


class FragmentAdd : Fragment() {

    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!
    lateinit var mAddViewModel: AddViewModel

    var res: Expense? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "FragmentAdd. onCreate")

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentAddBinding.inflate(inflater, container, false)
        Log.d(TAG, "FragmentAdd. onCreateView")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "FragmentAdd. onViewCreated")
    }



    override fun onStart() {
        super.onStart()
        Log.d(TAG, "FragmentAdd. onStart")
        mAddViewModel = ViewModelProvider(this).get(AddViewModel::class.java)

        childFragmentManager.setFragmentResultListener(DialogAddExpense.REQUEST_KEY, this) { _, result ->
            val r = result.getSerializable(DialogAddExpense.BUNDLE_KEY)
            Log.d(TAG, "FragmentAdd. childFragmentManager.FragmentResultListener, result=${r.toString()}")
        }

        binding.addFab.setOnClickListener {
            val dialog = DialogAddExpense()
            dialog.show(childFragmentManager, DialogAddExpense.DIALOG_TAG)
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "FragmentAdd. onResume")

    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "FragmentAdd. onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "FragmentAdd. onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "FragmentAdd. onDestroyView")
        _binding = null
    }

    fun showDialog(){
    }
    fun getResultFromDialog(){
    }
}