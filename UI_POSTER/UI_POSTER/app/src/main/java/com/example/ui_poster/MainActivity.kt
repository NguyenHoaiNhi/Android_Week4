package com.example.ui_poster

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var filmAdapter: FilmAdapter
    var film: ArrayList<MovieModel.Results> = ArrayList()
    val model = MovieModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // init clone film data
        addFilms()
        // set up layout manager and recyclerview
        rvFilms.layoutManager = LinearLayoutManager(this)
        filmAdapter = FilmAdapter(film, this)
        rvFilms.adapter = filmAdapter


    }
    private fun addFilms(){
        for(i in model.getMovieModel().results){
            film.add(i)
            Log.i("film array", film.toString())
        }


    }

}
