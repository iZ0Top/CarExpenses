package com.example.carexpenses.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.carexpenses.databinding.ItemEventBinding
import com.example.carexpenses.model.Event

class AdapterEvent: RecyclerView.Adapter<AdapterEvent.EventViewHolder>() {


    private var listEvents = emptyList<Event>()

    fun setData(listEvent: List<Event>){
        this.listEvents = listEvent
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int {
        return listEvents.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemEventBinding.inflate(layoutInflater, parent, false)
        return EventViewHolder(binding)
    }


    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {

        val event = listEvents[position]

        holder.binding.itemDate.text = event.date.toString()
        holder.binding.itemSum.text = event.sum.toString()
        holder.binding.itemOdometer.text = event.odometer.toString()

        holder.binding.itemRecyclerView

    }


    class EventViewHolder(val binding: ItemEventBinding): RecyclerView.ViewHolder(binding.root)
}