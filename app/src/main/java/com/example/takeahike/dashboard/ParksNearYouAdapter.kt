package com.example.takeahike.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.takeahike.R
import kotlinx.android.synthetic.main.card_park_near_me.view.*

class ParksNearYouAdapter(private val rows: List<Park>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_park_near_me, parent, false)
        return ParksNearYouItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return rows.size ?: 0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val park = rows[position]
        (holder as ParksNearYouItemViewHolder).bindData(park)
    }

    internal class ParksNearYouItemViewHolder(parksLineItem: View): RecyclerView.ViewHolder(parksLineItem) {
        fun bindData(park: Park) {
            itemView.park_name_textView.text = park.name
        }
    }

}