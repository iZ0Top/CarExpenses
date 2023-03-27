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

    fun setData(list: List<Event>){
        this.lisEvent = list
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

        val event = lisEvent[position]
        val eventExpense = event.listEventExpenses
        val eventRefueling = event.listEventRefueling
        val recyclerView = holder.binding.itemRecyclerView
        val mAdapter = AdapterEventChild()

        holder.binding.itemDate.text = event.date
        holder.binding.itemOdometer.text = event.odometer.toString()
        holder.binding.itemSum.text = event.sum.toString()
        recyclerView.adapter = mAdapter
        when(event.type){
            TYPE_REFUELING -> mAdapter.setData(eventRefueling, TYPE_REFUELING)
            TYPE_EXPENSE -> mAdapter.setData(eventExpense, TYPE_EXPENSE)
        }
    }
    class EventHolder(val binding: ItemEventBinding): RecyclerView.ViewHolder(binding.root){}
}