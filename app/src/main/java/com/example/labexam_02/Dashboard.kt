package com.example.labexam_02

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Dashboard : AppCompatActivity() {

    private var recyclerView : RecyclerView? = null
    private var recyclerViewMovieAdapter : RecyclerViewMovieAdapter? = null
    private var movieList = mutableListOf<Movie>()

    private var recyclerView1 : RecyclerView? = null
    private var recyclerViewMovieAdapter1 : RecyclerViewMovieAdapter1? = null
    private var movieList1 = mutableListOf<Movie1>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dashboard)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val firstbutton = findViewById<ImageView>(R.id.notebook)
        firstbutton.setOnClickListener{
            val Intent = Intent(this,MoviePage::class.java)
            startActivity(Intent)
        }


        movieList = ArrayList()
        recyclerView1= findViewById<View>(R.id.rvMovieLists1) as RecyclerView
        recyclerViewMovieAdapter1 = RecyclerViewMovieAdapter1(this@Dashboard, movieList1)
        val layoutManager1 = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView1!!.layoutManager = layoutManager1
        recyclerView1!!.adapter = recyclerViewMovieAdapter1
        prepareMovieListData1()

        movieList1 = ArrayList()
        recyclerView = findViewById<View>(R.id.rvMovieLists) as RecyclerView
        recyclerViewMovieAdapter = RecyclerViewMovieAdapter(this@Dashboard, movieList)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView!!.layoutManager = layoutManager
        recyclerView!!.adapter = recyclerViewMovieAdapter
        prepareMovieListData()



    }

    private fun prepareMovieListData1() {
        var movie1 = Movie1("Avtar", R.drawable.avatar1)
        movieList1.add(movie1)
        movie1 = Movie1("Avtar", R.drawable.titanic)
        movieList1.add(movie1)
        movie1 = Movie1("Avtar", R.drawable.hope)
        movieList1.add(movie1)
        movie1 = Movie1("Avtar", R.drawable.xfiles)
        movieList1.add(movie1)
        movie1 = Movie1("Avtar", R.drawable.avatar)
        movieList1.add(movie1)




        recyclerViewMovieAdapter1!!.notifyDataSetChanged()
    }

    private fun prepareMovieListData() {
       var movie = Movie("Avtar", R.drawable.download)
        movieList.add(movie)
        movie = Movie("1997", R.drawable.hope)
        movieList.add(movie)

        movie = Movie("Avtar", R.drawable.got)
        movieList.add(movie)
        movie = Movie("Avtar", R.drawable.cpt)
        movieList.add(movie)
        movie = Movie("Avtar", R.drawable.avatar)
        movieList.add(movie)


        recyclerViewMovieAdapter!!.notifyDataSetChanged()

    }




}