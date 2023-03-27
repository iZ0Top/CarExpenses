package com.example.carexpenses.adapters
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.carexpenses.databinding.ItemEventChildBinding
import com.example.carexpenses.model.EventExpense
import com.example.carexpenses.model.EventRefueling
import com.example.carexpenses.utils.TYPE_EXPENSE
import com.example.carexpenses.utils.TYPE_REFUELING

class AdapterEventChild: RecyclerView.Adapter<AdapterEventChild.EventChildHolder>() {

    private var list = emptyList<Any>()
    private var type = 0

    fun setData(list: List<Any>, type: Int){
        this.list = list
        this.type = type
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventChildHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemEventChildBinding.inflate(layoutInflater)
        return EventChildHolder(binding)
    }

    override fun onBindViewHolder(holder: EventChildHolder, position: Int) {
        holder.binding.itemInterpunct.text = "•"
        when(type){
            TYPE_EXPENSE -> {
                val event = list[position] as EventExpense
                with(holder.binding){
                    itemNameOrType.text = event.name
                    itemDescription.text = event.description
                    itemPartNumber.text = event.partNum
                    itemQuantityOrVolume.text = event.quantity.toString()
                    itemPrice.text = event.price.toString()
                }
            }
            TYPE_REFUELING -> {
                val event = list[position] as EventRefueling
                with(holder.binding){
                    itemNameOrType.text = event.fuelType.toString()
                    itemQuantityOrVolume.text = event.volume.toString()
                    itemDescription.visibility = View.GONE
                    itemPartNumber.visibility = View.GONE
                    itemPrice.text = event.price.toString()
                }
            }
        }
    }
    class EventChildHolder(val binding: ItemEventChildBinding ): RecyclerView.ViewHolder(binding.root){}
}