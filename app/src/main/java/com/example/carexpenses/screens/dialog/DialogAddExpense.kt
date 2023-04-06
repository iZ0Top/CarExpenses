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

    private var _dialogBinding: DialogAddExpenseBinding? = null
    private val dialogBinding get() = _dialogBinding!!
    private var expense: Expense? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        _dialogBinding = DialogAddExpenseBinding.inflate(layoutInflater)
        Log.d(TAG, "Dialog. onCreateDialog")

        expense = Expense(0,2, 123456,"01.01.0101", "Name", "Description", "AAA00000", 2, 58)

        val listener = DialogInterface.OnClickListener { _, _ ->
            validationData()
            val bundle = Bundle()
            bundle.putSerializable(BUNDLE_KEY, expense)
            parentFragmentManager.setFragmentResult(REQUEST_KEY, bundle)
        }


        val dialog = AlertDialog.Builder(requireContext())
            .setCancelable(false)
            .setView(dialogBinding.root)
            .setPositiveButton("Ok", listener)
        return dialog.create()
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "Dialog. onResume")

    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        Log.d(TAG, "Dialog. onDismiss")
    }

    override fun onCancel(dialog: DialogInterface) {
        super.onCancel(dialog)
        Log.d(TAG, "Dialog. onCancel")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "Dialog. onDestroyView")

    }

    fun validationData(){

        val name = dialogBinding.etName.text.toString()
        val description = dialogBinding.etDescription.text.toString()
        val partNum = dialogBinding.etPartNum.text.toString()
        val amount = dialogBinding.etPartNum.text.toString().toIntOrNull()
        val sum = dialogBinding.etPrice.text.toString().toIntOrNull()




    }

    companion object{
        val DIALOG_TAG = DialogAddExpense::class.java.simpleName
        val REQUEST_KEY = "dialog_add_request_key"
        val BUNDLE_KEY = "dialog_add_bundle_key"




    }
}