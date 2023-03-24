package com.example.carexpenses.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.carexpenses.databinding.ItemEventExpenseBinding
import com.example.carexpenses.model.EventExpense
import com.example.carexpenses.model.EventRefueling
import com.example.carexpenses.utils.TAG

class AdapterEventExpense: RecyclerView.Adapter<AdapterEventExpense.EventExpenseHolder>() {

    private var listEventExpense = emptyList<EventExpense>()

    fun setListEventExpense(list: List<EventExpense>){
        this.listEventExpense = list

    }

    override fun getItemCount(): Int {
        return listEventExpense.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventExpenseHolder {
        Log.d(TAG, "AdapterEventExpense, onBindViewHolder")
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemEventExpenseBinding.inflate(layoutInflater)
        return EventExpenseHolder(binding)
    }

    override fun onBindViewHolder(holder: EventExpenseHolder, position: Int) {
        val eventExpense = listEventExpense[position]

        holder.itInter.text = "•"

        with(holder.binding){
            itemInterpunct.text = "•"
            itemName.text = eventExpense.name
            itemDescription.text = eventExpense.description
            itemPartNumber.text = eventExpense.partNum
            itemQuantity.text = eventExpense.quantity.toString()
            itemPrice.text = eventExpense.price.toString()
        }
    }

    class EventExpenseHolder(val binding: ItemEventExpenseBinding): RecyclerView.ViewHolder(binding.root){

        val itInter = binding.itemInterpunct
    }
}