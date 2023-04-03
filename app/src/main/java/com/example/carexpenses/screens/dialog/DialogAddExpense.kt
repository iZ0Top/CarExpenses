package com.example.carexpenses.screens.dialog

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import com.example.carexpenses.databinding.DialogAddExpenseBinding

class DialogAddExpense: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialogBinding = DialogAddExpenseBinding.inflate(layoutInflater)
        val listener = DialogInterface.OnClickListener { _, which ->
            parentFragmentManager.setFragmentResult(REQUEST_KEY, bundleOf(RESPONSE_KEY to which))
        }

        val dialog = AlertDialog.Builder(requireContext())
            .setCancelable(false)
            .setView(dialogBinding.root).setPositiveButton("Ok", listener)
        return dialog.create()
    }


    companion object{
        val REQUEST_KEY = "request_key"
        val RESPONSE_KEY = "response_key"
        val ARG_DIALOG = "arguments_dialog_expense"


        fun showDialog(){
            val dialog = DialogAddExpense()
            dialog.arguments = bundleOf()

        }
        fun setupListener(){

        }

    }
}