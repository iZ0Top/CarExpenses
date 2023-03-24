package com.example.carexpenses.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.carexpenses.databinding.ItemEventRefuelingBinding
import com.example.carexpenses.model.EventRefueling

class AdapterEventRefueling: RecyclerView.Adapter<AdapterEventRefueling.EventRefuelingHolder>() {

    private lateinit var listEventRefueling: List<EventRefueling>

    fun setListEventRefueling(list: List<EventRefueling>){
        this.listEventRefueling = list
    }

    override fun getItemCount() = listEventRefueling.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventRefuelingHolder {
        val layoutInFlatter = LayoutInflater.from(parent.context)
        val binding = ItemEventRefuelingBinding.inflate(layoutInFlatter)
        return EventRefuelingHolder(binding)
    }

    override fun onBindViewHolder(holder: EventRefuelingHolder, position: Int) {
        val eventRefueling = listEventRefueling[position]

        with(holder.binding){
            itemFuelType.text = eventRefueling.fuelType.toString()
            itemFuelVolume.text = eventRefueling.volume.toString()
            itemFuelPrice.text = eventRefueling.price.toString()
        }
    }

    class EventRefuelingHolder(val binding: ItemEventRefuelingBinding): RecyclerView.ViewHolder(binding.root){
    }
}