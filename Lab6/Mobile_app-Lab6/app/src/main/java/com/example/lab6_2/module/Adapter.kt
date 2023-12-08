package com.example.lab6_2.module


import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lab6_2.PicViewer
import com.example.lab6_2.R
import com.example.lab6_2.data.ImageData


class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val image: ImageView? = view.findViewById(R.id.picView)

    fun bindTo(data: ImageData) {
        image?.let {
            Glide.with(itemView.context)
                .load(data.imageUrl)
                .into(it)
        }

        image?.setOnClickListener {
            val intent = Intent(itemView.context, PicViewer::class.java)
            intent.putExtra("picLink", data.imageUrl)
//            itemView.context.startActivity(intent)
            if (itemView.context is Activity){
                (itemView.context as Activity).startActivityForResult(intent, 1)
            }
        }
    }
}

class Adapter : ListAdapter<ImageData, ViewHolder>(ContactDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.rview_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }

}