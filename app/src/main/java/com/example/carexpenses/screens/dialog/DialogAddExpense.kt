package com.example.carexpenses.screens.dialog

import android.app.Dialog
import android.content.DialogInterface
import android.content.DialogInterface.OnClickListener
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentResultListener
import androidx.fragment.app.setFragmentResult
import androidx.lifecycle.LifecycleOwner
import com.example.carexpenses.databinding.DialogAddExpenseBinding
import com.example.carexpenses.model.Event
import com.example.carexpenses.model.Expense
import com.example.carexpenses.utils.TAG

class DialogAddExpense: DialogFragment() {




    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialogBinding = DialogAddExpenseBinding.inflate(layoutInflater)

        val expense = Expense(0,2, 123456,"01.01.0101", "Name", "Description", "AAA00000", 2, 58)
        val testText = "testText"
        val listener = DialogInterface.
        }

        val dialog = AlertDialog.Builder(requireContext())
            .setCancelable(false)
            .setView(dialogBinding.root)
            .setPositiveButton("Ok", listener)
        return dialog.create()
    }


    companion object{
        val DIALOG_TAG = DialogAddExpense::class.java.simpleName
        val DIALOG_ARG = "dialog_add_expense_arguments"
        val REQUEST_KEY = "dialog_add_request_key"
        val BUNDLE_KEY = "dialog_add_response_key"



        fun showDialog(fManager: FragmentManager, expense: Expense?){
            val dialog = DialogAddExpense()
//            val bundle = Bundle()
//            bundle.putSerializable("1", expense)
//            dialog.arguments = bundle
            dialog.show(fManager, DIALOG_TAG)
        }
        fun setupListener(fManager: FragmentManager, lifecycleOwner: LifecycleOwner, listener: (Expense) -> Unit){

        }
    }
}