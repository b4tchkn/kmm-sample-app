package com.batch.kmm_sample_app.androidApp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.batch.kmm_sample_app.shared.data.model.Actress

class ActressesRecyclerViewAdapter(var actresses: List<Actress>) :
    RecyclerView.Adapter<ActressesRecyclerViewAdapter.ActressesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActressesViewHolder {
        return LayoutInflater.from(parent.context)
            .inflate(R.layout.item_main_actress, parent, false)
            .run(::ActressesViewHolder)
    }

    override fun onBindViewHolder(holder: ActressesViewHolder, position: Int) {
        holder.bindData(actress = actresses[position])
    }

    override fun getItemCount(): Int = actresses.size

    inner class ActressesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val name = itemView.findViewById<TextView>(R.id.item_main_actress_name)
        private val iconImage = itemView.findViewById<ImageView>(R.id.item_main_actress_icon_image)
        fun bindData(actress: Actress) {
            name.text = actress.name
            iconImage.load(actress.imageUrl?.large)
        }
    }
}