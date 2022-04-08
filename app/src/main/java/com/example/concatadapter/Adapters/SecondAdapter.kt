package com.example.concatadapter.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.concatadapter.databinding.SecondItemsBinding

class SecondAdapter(private var itemList: MutableList<String> = mutableListOf()) :
    RecyclerView.Adapter<SecondHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecondHolder {
        val binding =
            SecondItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SecondHolder(binding)
    }

    override fun onBindViewHolder(holder: SecondHolder, position: Int) {
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

class SecondHolder(val binding: SecondItemsBinding) : RecyclerView.ViewHolder(binding.root) {

    fun setItem(item: String) {
        binding.item.text = item
    }
}
