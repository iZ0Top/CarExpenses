package com.example.carexpenses.screens.add
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.carexpenses.adapters.add.AdapterAdd
import com.example.carexpenses.databinding.FragmentAddBinding
import com.example.carexpenses.model.Expense
import com.example.carexpenses.screens.dialog.DialogAddExpense
import com.example.carexpenses.utils.TAG


class FragmentAdd : Fragment() {

    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!

    lateinit var mAddViewModel: AddViewModel

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: AdapterAdd
    private lateinit var mObserver: Observer<List<Expense>>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "FragmentAdd. onCreate")
        mAddViewModel = ViewModelProvider(this).get(AddViewModel::class.java)

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

        mRecyclerView = binding.addRecyclerView
        mAdapter = AdapterAdd()
        mRecyclerView.adapter = mAdapter


        mObserver = Observer {
            mAdapter.setList(it)
        }

        mAddViewModel.currentExpenseList.observe(viewLifecycleOwner, mObserver)

        childFragmentManager.setFragmentResultListener(DialogAddExpense.REQUEST_KEY, this) { _, result ->
            val expense = result.getSerializable(DialogAddExpense.BUNDLE_KEY) as Expense
            mAddViewModel.addToList(expense)
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
        mAddViewModel.currentExpenseList.removeObservers(viewLifecycleOwner)
        mRecyclerView.adapter = null
        _binding = null
    }
}