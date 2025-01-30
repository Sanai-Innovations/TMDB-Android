package com.sanai.tmdbclient.presentation.ui.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sanai.tmdbclient.R
import com.sanai.tmdbclient.data.model.movie.Movie
import com.sanai.tmdbclient.databinding.ItemListBinding

class MoviesAdapter : RecyclerView.Adapter<ViewHolder>() {

    private var movieList = ArrayList<Movie>()

    fun setList(list: List<Movie>?) {
        movieList.clear()

        if (list?.isNotEmpty() == true) {
            movieList.addAll(list)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            DataBindingUtil.inflate(
                layoutInflater,
                R.layout.item_list,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movieList[position])
    }
}

class ViewHolder(private val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(movie: Movie?) {
        binding.titleTextView.text = movie?.title
        binding.descriptionTextView.text = movie?.overview
        val posterURL = "https://image.tmdb.org/t/p/w500${movie?.posterPath}"
        Glide.with(binding.imageView.context)
            .load(posterURL)
            .into(binding.imageView)
    }
}