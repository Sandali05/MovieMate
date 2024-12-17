package com.example.labexam_02

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewMovieAdapter1 constructor(
    private val getActivity: Dashboard,
    private val movieList: List<Movie1>):
    RecyclerView.Adapter<RecyclerViewMovieAdapter1.MyViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_movie_list_item1, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movieList.size

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.inMovieImg1.setImageResource(movieList[position].image)

        holder.cardView1.setOnClickListener{
            Toast.makeText(getActivity, movieList[position].title, Toast.LENGTH_LONG).show()
        }


    }


    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val inMovieImg1 : ImageView = itemView.findViewById(R.id.inMovieImg1)
        val cardView1 : CardView = itemView.findViewById(R.id.cardView1)
    }



}