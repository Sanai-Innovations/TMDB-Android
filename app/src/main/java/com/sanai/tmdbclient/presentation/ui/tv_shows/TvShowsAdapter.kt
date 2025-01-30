package com.sanai.tmdbclient.presentation.ui.tv_shows

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sanai.tmdbclient.R
import com.sanai.tmdbclient.data.model.tv_show.TvShow
import com.sanai.tmdbclient.databinding.ItemListBinding

class TvShowsAdapter : RecyclerView.Adapter<ViewHolder>() {

    private var tvShowsList = ArrayList<TvShow>()

    fun setList(list: List<TvShow>?) {
        tvShowsList.clear()

        if (list?.isNotEmpty() == true) {
            tvShowsList.addAll(list)
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
        return tvShowsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(tvShowsList[position])
    }
}

class ViewHolder(private val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(tvShow: TvShow?) {
        binding.titleTextView.text = tvShow?.name
        binding.descriptionTextView.text = tvShow?.overview
        val posterURL = "https://image.tmdb.org/t/p/w500${tvShow?.posterPath}"
        Glide.with(binding.imageView.context)
            .load(posterURL)
            .into(binding.imageView)
    }
}