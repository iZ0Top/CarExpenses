package com.example.carexpenses.adapters.add

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.carexpenses.databinding.ItemExpenseBinding
import com.example.carexpenses.model.Expense

class AdapterAdd: RecyclerView.Adapter<AdapterAdd.ItemHolder>(){

    private var currentList = emptyList<Expense>()

    fun setList(list: List<Expense>){
        currentList = list
        notifyDataSetChanged()
    }

    class ItemHolder(val binding: ItemExpenseBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemExpenseBinding.inflate(layoutInflater, parent, false )
        return ItemHolder(binding)
    }

    override fun getItemCount() = currentList.size

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val expense = currentList[position]

        holder.binding.itemNameOrType.text = expense.name
        holder.binding.itemDescription.text = expense.description
        holder.binding.itemPartNumber.text = expense.part_number
        holder.binding.itemQuantityOrVolume.text = expense.amount.toString()
        holder.binding.itemPrice.text = expense.sum.toString()
    }
}