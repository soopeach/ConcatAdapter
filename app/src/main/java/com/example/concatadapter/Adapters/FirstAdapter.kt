package com.example.concatadapter.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.concatadapter.databinding.FirstItemsBinding

class FirstAdapter(private var itemList: MutableList<String> = mutableListOf()):RecyclerView.Adapter<FirstHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirstHolder {
        val binding = FirstItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FirstHolder(binding)
    }

    override fun onBindViewHolder(holder: FirstHolder, position: Int) {
        holder.setItem(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun addItem(item : String){
        this.itemList.add(item)

        notifyItemInserted(itemList.size-1)
    }



}

class FirstHolder(val binding: FirstItemsBinding) : RecyclerView.ViewHolder(binding.root){

    fun setItem(item : String){
        binding.item.text = item
    }

}

