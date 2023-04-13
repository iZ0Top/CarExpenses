package com.example.carexpenses.screens.dialog

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.carexpenses.databinding.DialogAddExpenseBinding
import com.example.carexpenses.model.Expense
import com.example.carexpenses.utils.TAG
import java.text.SimpleDateFormat
import java.util.*

class DialogAddExpense: DialogFragment() {

    private var _dialogBinding: DialogAddExpenseBinding? = null
    private val dialogBinding get() = _dialogBinding!!
    private var expense: Expense? = null


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        _dialogBinding = DialogAddExpenseBinding.inflate(layoutInflater)
        Log.d(TAG, "Dialog. onCreateDialog")

        var dialogBuilder = AlertDialog.Builder(requireContext())
            .setCancelable(false)
            .setView(dialogBinding.root)
            .setPositiveButton("Ok", null)
            .setNegativeButton("Cancel", null)

        return dialogBuilder.create()
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "Dialog. onResume")

        val d = dialog as AlertDialog
        val buttonPositive = d.getButton(DialogInterface.BUTTON_POSITIVE) as Button
        buttonPositive.setOnClickListener {
            Log.d(TAG, "Dialog. onResume. Click button OK")
            validationData()
        }
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

    private fun validationData(){
        Log.d(TAG, "Dialog. validationData")

        val tmp_id = 0
        val tmp_groupId = 0
        val tmp_odometer = 123456
        val tmp_date_format = SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.US)
        val tmp_date = tmp_date_format.format(Date()).toString()

        val name = dialogBinding.etName.text.toString()
        val description = dialogBinding.etDescription.text.toString()
        val partNum = dialogBinding.etPartNum.text.toString()
        var amount = dialogBinding.etPartNum.text.toString().toIntOrNull()
        val sum = dialogBinding.etPrice.text.toString().toIntOrNull()

        if (name == ""){ dialogBinding.etName.error = "Is empty !" }
        if (sum == null){ dialogBinding.etPrice.error = "Is empty !" }
        if (amount == null) amount = 0

        if (name == "" || sum == null){
            Log.d(TAG,"Dialog. validationData - name or sum = null. return" )
            return
        }

        expense = Expense(tmp_id, tmp_groupId, tmp_odometer, tmp_date, name, description, partNum, amount, sum)
        val bundle = Bundle()
        bundle.putSerializable(BUNDLE_KEY, expense)
        parentFragmentManager.setFragmentResult(REQUEST_KEY, bundle)

        Log.d(TAG,"Dialog. validationData - parentFragmentManager.setFragmentResult result sent" )

        dismiss()
    }

    companion object{
        val DIALOG_TAG = DialogAddExpense::class.java.simpleName
        const val REQUEST_KEY = "dialog_add_request_key"
        const val BUNDLE_KEY = "dialog_add_bundle_key"

    }
}