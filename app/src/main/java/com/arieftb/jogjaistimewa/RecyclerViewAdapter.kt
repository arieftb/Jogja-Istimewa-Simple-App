package com.arieftb.jogjaistimewa

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_item_culinary.view.*

class RecyclerViewAdapter(private val context: Context, private val culinaryList: List<Culinary>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item_culinary, parent, false))

    override fun getItemCount(): Int = culinaryList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(culinaryList[position])
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val culinaryName = view.text_culinary_name
        private val culinaryImage = view.image_culinary_thumb

        fun bind(culinary: Culinary) {
            culinaryName.text = culinary.culinaryName
            culinaryImage.apply {
                Picasso.get().load(culinary.culinaryImage).into(this)
            }
        }
    }
}