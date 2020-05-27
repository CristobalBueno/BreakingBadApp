package com.example.cristobalbuenoexam.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cristobalbuenoexam.Fragments.CharactersFragment
import com.example.cristobalbuenoexam.Models.ResultItem
import com.example.cristobalbuenoexam.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_events.view.*

class EventsAdapter(private val data: ArrayList<ResultItem>, val clickAction: CharactersFragment) : RecyclerView.Adapter<EventsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_events, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])

        holder.itemView.card.setOnLongClickListener {
            clickAction.onLongItemClick(data[position])
            return@setOnLongClickListener true
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: ResultItem) {

            itemView.mytexto.text = item.name

            Picasso.get().load(item.img).into(itemView.myImg)

            itemView.card.setOnClickListener {
                Log.v("miapp", item.toString())
                clickAction.onItemClick(item)
            }
        }
    }
}