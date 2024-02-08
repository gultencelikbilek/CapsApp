package com.example.castapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.castapp.databinding.CapsRecyclerviewLayoutBinding
import com.example.castapp.model.CapsItem

class CapsAdapter(val context : Context) : RecyclerView.Adapter<CapsAdapter.CapsViewHolder>(){

    class CapsViewHolder( val binding : CapsRecyclerviewLayoutBinding): RecyclerView.ViewHolder(binding.root)

    private val diffCalback = object : DiffUtil.ItemCallback<CapsItem>(){
        override fun areItemsTheSame(oldItem: CapsItem, newItem: CapsItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: CapsItem, newItem: CapsItem): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this,diffCalback)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CapsViewHolder {
        return CapsViewHolder(CapsRecyclerviewLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: CapsViewHolder, position: Int) {
         val currentItem = differ.currentList[position]
         holder.binding.apply {
             tvCapsName.text = currentItem.name
             Glide
                 .with(context)
                 .load(currentItem.url)
                 .into(ivCaps)
         }
    }

}