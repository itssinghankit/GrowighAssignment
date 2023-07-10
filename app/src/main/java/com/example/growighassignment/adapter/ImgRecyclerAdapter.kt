package com.example.growighassignment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.growighassignment.R

class ImgRecyclerAdapter(
    val list: List<com.example.growighassignment.modelClasses.Result>,
    val context: Context
) : RecyclerView.Adapter<ImgRecyclerAdapter.viewholder>() {

    class viewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var img = itemView.findViewById<ImageView>(R.id.img)
        var description = itemView.findViewById<TextView>(R.id.description)
        var likes = itemView.findViewById<TextView>(R.id.likes)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.feeds_reycler_item, parent, false)
        return viewholder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        holder.description.text = list[position].description
        holder.likes.text = "${list[position].likes} Likes"
        Glide.with(context).load(list[position].urls.small)
            .placeholder(R.drawable.image_placeholder).into(holder.img)
    }
}