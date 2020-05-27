package com.example.cristobalbuenoexam.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cristobalbuenoexam.Interfaces.CustomItemListener
import com.example.cristobalbuenoexam.Models.ResultItem
import com.example.cristobalbuenoexam.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_events.view.*

class FavoriteAdapter (private val data: ArrayList<ResultItem>, val clickAction: CustomItemListener) : RecyclerView.Adapter<FavoriteAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_events, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
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