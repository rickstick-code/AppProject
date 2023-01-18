package com.example.justplanit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.time.format.DateTimeFormatter
import java.util.*

class ProgressAdapter(var fortschritte: List<Fortschritt>): RecyclerView.Adapter<ProgressAdapter.ViewHolder>() { // add progress class

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(fortschritt: Fortschritt) {
            itemView.findViewById<TextView>(R.id.item_progress_id).text =
                fortschritt.id.toString()
            itemView.findViewById<TextView>(R.id.item_progress_activity).text =
                fortschritt.aktivitaet.toString()
            itemView.findViewById<TextView>(R.id.item_progress_amount).text =
                fortschritt.zielmenge.toString()
            itemView.findViewById<TextView>(R.id.item_progress_date).text =
                Converter().dateToString(fortschritt.datum)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val progressItemView = inflater.inflate(R.layout.item_progress, parent, false)
        return ViewHolder(progressItemView)
    }

    override fun getItemCount(): Int {
        return fortschritte.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, postion: Int) {
        holder.bindItem(fortschritte[postion])
    }

}