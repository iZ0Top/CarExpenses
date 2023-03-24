package com.example.carexpenses.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.carexpenses.databinding.ItemEventBinding
import com.example.carexpenses.model.Event
import com.example.carexpenses.utils.TAG
import com.example.carexpenses.utils.TYPE_EXPENSE
import com.example.carexpenses.utils.TYPE_REFUELING

class AdapterEvent: RecyclerView.Adapter<AdapterEvent.EventHolder>() {

    private var lisEvent = emptyList<Event>()
    lateinit var recyclerView: RecyclerView

    fun setData(list: List<Event>){
        this.lisEvent = list
        Log.d(TAG, "AdapterEvent, event list size: ${lisEvent.size}")
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemEventBinding.inflate(layoutInflater, parent, false)
        return EventHolder(binding)
    }

    override fun getItemCount(): Int {
        return lisEvent.size
    }

    override fun onBindViewHolder(holder: EventHolder, position: Int) {
        Log.d(TAG, "AdapterEvent, onBindViewHolder")
        val event = lisEvent[position]
        val eventExpense = event.listEventExpenses
        val eventRefueling = event.listEventRefueling
        recyclerView = holder.binding.itemRecyclerView

        holder.binding.itemDate.text = event.date
        holder.binding.itemOdometer.text = event.odometer.toString()
        holder.binding.itemSum.text = event.sum.toString()
        holder.binding.itemRecyclerView

        if (event.type == TYPE_EXPENSE){
            Log.d(TAG, "AdapterEvent, event expense list size: ${eventExpense.size}")
            val adapterEventExpense = AdapterEventExpense()
            recyclerView.adapter = adapterEventExpense
            adapterEventExpense.setChildListEventExpense(eventExpense)
        }
        if (event.type == TYPE_REFUELING){
            Log.d(TAG, "AdapterEvent, event refueling list size: ${eventRefueling.size}")
            val adapterEventRefueling = AdapterEventRefueling()
            recyclerView.adapter = adapterEventRefueling
            adapterEventRefueling.setListEventRefueling(eventRefueling)
        }
    }

    class EventHolder(val binding: ItemEventBinding): RecyclerView.ViewHolder(binding.root){
        val date = binding.itemDate
        val odometer = binding.itemOdometer
        val sum = binding.itemSum
    }
}