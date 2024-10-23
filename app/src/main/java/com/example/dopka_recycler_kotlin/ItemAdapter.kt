package com.example.dopka_recycler_kotlin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.dopka_recycler_kotlin.databinding.ItemBinding

class ItemAdapter(val list: ArrayList<String>, val onClick: (text:String) -> Unit): Adapter<ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(ItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(list[position])
        holder.itemView.setOnClickListener {
            onClick(list[position])
        }
    }
}

class ItemViewHolder(private var binding: ItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(text: String) {
        binding.tvListItem.text = text
    }
}