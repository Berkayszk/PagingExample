package com.example.pagingexample.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.pagingexample.databinding.RickMortyLayoutBinding
import com.example.pagingexample.model.RickMorty

class RickMortyAdapter : PagingDataAdapter<RickMorty, RickMortyAdapter.MyViewHolder>(diffCallBack) {

    class MyViewHolder(val binding: RickMortyLayoutBinding) : RecyclerView.ViewHolder(binding.root){

    }

    companion object{
        val diffCallBack = object :DiffUtil.ItemCallback<RickMorty>(){
            override fun areItemsTheSame(oldItem: RickMorty, newItem: RickMorty): Boolean {
                 return oldItem.id==newItem.id
            }

            override fun areContentsTheSame(oldItem: RickMorty, newItem: RickMorty): Boolean {
                return oldItem==newItem
            }

        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = getItem(position) //this method is from PagingDataAdapter***

        holder.binding.apply {
            textView.text = "${currentItem?.name}"

            val imageLink = currentItem?.image

            //using coroutine image loader coil
            imageView.load(imageLink){
                crossfade(true)
                crossfade(1000)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(RickMortyLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
}