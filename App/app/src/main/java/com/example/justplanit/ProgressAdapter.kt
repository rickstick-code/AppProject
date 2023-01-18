package com.example.justplanit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProgressAdapter(val progressList: List<Fortschritt>): RecyclerView.Adapter<ProgressAdapter.ViewHolder>() {

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bindItem(progress:Fortschritt){
            itemView.findViewById<TextView>(R.id.item_progress_activity).text = progress.aktivitaet.toString()
            itemView.findViewById<TextView>(R.id.item_progress_amount).text = progress.zielmenge.toString() + " " +  progress.metrik
            itemView.findViewById<TextView>(R.id.item_progress_date).text = progress.datum.toString()
            //itemView.findViewById<ImageView>(R.id.item_progress_delete).setOnClickListener { }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val progressItemView = inflater.inflate(R.layout.item_progress, parent, false)
        return ViewHolder(progressItemView)
    }

    override fun getItemCount(): Int {
        return progressList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val progress = progressList[position]
        holder.bindItem(progress)
    }
}