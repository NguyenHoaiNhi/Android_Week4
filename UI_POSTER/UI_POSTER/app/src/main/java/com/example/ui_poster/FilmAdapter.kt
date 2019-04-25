package com.example.ui_poster

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_film.view.*
import java.text.FieldPosition

/**
 * Created by Nhi Nguyen on 4/25/19
 */
class FilmAdapter(var items: ArrayList<MovieModel.Results>, val context: Context) : RecyclerView.Adapter<FilmViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): FilmViewHolder {
        return FilmViewHolder(LayoutInflater.from(context).inflate(R.layout.item_film, parent,false))
    }

    override fun getItemCount(): Int {
        return items.size
    }
    override fun onBindViewHolder(filmViewHolder: FilmViewHolder, position: Int) {
        filmViewHolder.tvName.text = items.get(position).title
        filmViewHolder.tvContent.text = items.get(position).overview
        Glide.with(context)
            .load("https://image.tmdb.org/t/p/w500/"+items.get(position).poster_path)
            .centerCrop()
            .placeholder(R.drawable.student_place_holder)
            .into(filmViewHolder.tvAvatar)
    }


}
class FilmViewHolder(view: View) : RecyclerView.ViewHolder(view){
    var tvAvatar = view.ivAvatar
    var tvName = view.NameFilm
    var tvContent = view.content
}
