package com.example.carexpenses.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.carexpenses.databinding.ItemEventExpenseBinding
import com.example.carexpenses.model.EventExpense
import com.example.carexpenses.utils.TAG

class AdapterEventExpense: RecyclerView.Adapter<AdapterEventExpense.EventExpenseHolder>() {

    private var listEventExpense = emptyList<EventExpense>()

    fun setChildListEventExpense(list: List<EventExpense>){
        this.listEventExpense = list
        notifyDataSetChanged()
        Log.d(TAG, "AdapterEventExpense, setListEventExpense, ListSize: ${listEventExpense.size}")
    }

    override fun getItemCount(): Int {
        Log.d(TAG, "AdapterEventExpense, getItemCount")
        return listEventExpense.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventExpenseHolder {
        Log.d(TAG, "AdapterEventExpense, onCreateViewHolder")
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemEventExpenseBinding.inflate(layoutInflater)
        return EventExpenseHolder(binding)
    }

    override fun onBindViewHolder(holder: EventExpenseHolder, position: Int) {
        Log.d(TAG, "AdapterEventExpense, onBindViewHolder")
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