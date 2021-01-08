package com.batch.kmm_sample_app.androidApp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.batch.kmm_sample_app.shared.data.model.Actress

class ActressesRecyclerViewAdapter(var actresses: List<Actress>, private val context: Context) :
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
        private val nameTextView = itemView.findViewById<TextView>(R.id.item_main_actress_name)
        private val bustTextView = itemView.findViewById<TextView>(R.id.item_main_actress_bust)
        private val cupTextView = itemView.findViewById<TextView>(R.id.item_main_actress_cup)
        private val waistTextView = itemView.findViewById<TextView>(R.id.item_main_actress_waist)
        private val hipTextView = itemView.findViewById<TextView>(R.id.item_main_actress_hip)
        private val birthdayTextView =
            itemView.findViewById<TextView>(R.id.item_main_actress_birthday)
        private val iconImage = itemView.findViewById<ImageView>(R.id.item_main_actress_icon_image)

        fun bindData(actress: Actress) {
            nameTextView.text = actress.name
            if (!actress.bust.isNullOrEmpty())
                bustTextView.text = context.getString(R.string.item_main_actress_bust, actress.bust)
            if (!actress.cup.isNullOrEmpty())
                cupTextView.text = context.getString(R.string.item_main_actress_cup, actress.cup)
            if (!actress.waist.isNullOrEmpty())
                waistTextView.text =
                    context.getString(R.string.item_main_actress_waist, actress.waist)
            if (!actress.hip.isNullOrEmpty())
                hipTextView.text = context.getString(R.string.item_main_actress_hip, actress.hip)
            if (!actress.birthday.isNullOrEmpty())
                birthdayTextView.text =
                    context.getString(R.string.item_main_actress_birthday, actress.birthday)
            if (!actress.imageUrl?.large.isNullOrEmpty())
                iconImage.load(actress.imageUrl?.large)

        }
    }
}