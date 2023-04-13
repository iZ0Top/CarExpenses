package com.example.carexpenses.adapters.add

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.carexpenses.databinding.ItemExpenseBinding
import com.example.carexpenses.model.Expense
import com.example.carexpenses.utils.TAG

class AdapterAdd: RecyclerView.Adapter<AdapterAdd.ItemHolder>(){

    private var currentList = emptyList<Expense>()

    fun setList(list: List<Expense>){
        Log.d(TAG, "AdapterAdd. setList, list size = ${list.size}")
        currentList = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return currentList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        Log.d(TAG, "AdapterAdd. onCreateViewHolder")
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemExpenseBinding.inflate(layoutInflater, parent, false )
        return ItemHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        Log.d(TAG, "AdapterAdd. onBindViewHolder")
        val expense = currentList[position]

        holder.binding.itemNameOrType.text = expense.name
        holder.binding.itemDescription.text = expense.description
        holder.binding.itemPartNumber.text = expense.part_number
        holder.binding.itemQuantityOrVolume.text = expense.amount.toString()
        holder.binding.itemPrice.text = expense.sum.toString()
    }

    class ItemHolder(val binding: ItemExpenseBinding): RecyclerView.ViewHolder(binding.root)
}