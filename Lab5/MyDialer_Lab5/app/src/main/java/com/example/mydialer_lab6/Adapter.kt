package com.example.mydialer_lab6

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import timber.log.Timber

class Adapter(private val context: Context,
              private val list: ArrayList<Contact>,
              private val jsonText: String,
              private val mainActivity: MainActivity) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    //    private val copy = arrayListOf<Contact>()
//    init {
//        for(i in 0 until list.size){
//            copy.add(Contact(list[i].name, list[i].phone, list[i].type))
//        }
//    }
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val textName: TextView = view.findViewById(R.id.textName)
        val textPhone: TextView = view.findViewById(R.id.textPhone)
        val textType: TextView = view.findViewById(R.id.textType)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.rview_item,parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textName.text = list[position].name
        holder.textPhone.text = list[position].phone
        holder.textType.text = list[position].type


    }

}