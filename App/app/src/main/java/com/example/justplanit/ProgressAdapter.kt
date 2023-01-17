package com.example.justplanit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProgressAdapter(val test:String): RecyclerView.Adapter<ProgressAdapter.ViewHolder>() { // add progress class

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bindItem(test:String){      // bindItem has to contain the progress table instead of test
            itemView.findViewById<TextView>(R.id.item_progress_activity)
            itemView.findViewById<TextView>(R.id.item_progress_amount)
            itemView.findViewById<TextView>(R.id.item_progress_date)
            itemView.findViewById<ImageView>(R.id.item_progress_delete)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val progressItemView = inflater.inflate(R.layout.item_progress, parent, false)
        return ViewHolder(progressItemView)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented") // (return progress size)
    }

    override fun onBindViewHolder(holder: ViewHolder, postion: Int) {
        holder.bindItem("asdasd") //replace with progress id
    }
}