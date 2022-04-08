package com.example.concatadapter.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.concatadapter.databinding.ThirdItemsBinding

class ThirdAdapter(private var itemList: MutableList<String> = mutableListOf()) :
    RecyclerView.Adapter<ThirdHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThirdHolder {
        val binding =
            ThirdItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ThirdHolder(binding)
    }

    override fun onBindViewHolder(holder: ThirdHolder, position: Int) {
        holder.setItem(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun addItem(item: String) {
        itemList.add(item)
        notifyItemInserted(itemList.size - 1)
    }
}

class ThirdHolder(val binding: ThirdItemsBinding) : RecyclerView.ViewHolder(binding.root) {

    fun setItem(item: String) {
        binding.item.text = item
    }
}