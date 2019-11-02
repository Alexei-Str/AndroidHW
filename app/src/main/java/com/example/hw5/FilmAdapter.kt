package com.example.hw5

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FilmAdapter(private val films: List<Film>) :
    RecyclerView.Adapter<FilmAdapter.FilmHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmHolder {
        val itemView =
            LayoutInflater.from(parent?.context).inflate(R.layout.list_item_view, parent, false)
        return FilmHolder(itemView)
    }

    override fun getItemCount(): Int = films.size

    override fun onBindViewHolder(holder: FilmHolder, position: Int) {
        holder?.textView?.text = films[position].title
        holder?.imageView?.setImageResource(films[position].img)
        holder.itemView.setOnClickListener { v ->
            val intent = Intent(v.context, PageActivity::class.java)
            intent.putExtra("img", films[position].img)
            intent.putExtra("title", films[position].title)
            intent.putExtra("description", films[position].description)
            v?.context?.startActivity(intent)
        }
    }

    class FilmHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        var textView: TextView? = itemView?.findViewById(R.id.text_list_item)
        var imageView: ImageView? = itemView?.findViewById(R.id.recycler_image)
    }
}