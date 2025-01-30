package com.sanai.tmdbclient.presentation.ui.artists

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sanai.tmdbclient.R
import com.sanai.tmdbclient.data.model.artist.Artist
import com.sanai.tmdbclient.databinding.ItemListBinding

class ArtistsAdapter : RecyclerView.Adapter<ViewHolder>() {

    private var artistsList = ArrayList<Artist>()

    fun setList(list: List<Artist>?) {
        artistsList.clear()

        if (list?.isNotEmpty() == true) {
            artistsList.addAll(list)
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
        return artistsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(artistsList[position])
    }
}

class ViewHolder(private val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(artist: Artist?) {
        binding.titleTextView.text = artist?.name
        binding.descriptionTextView.text = artist?.knownForDepartment
        val posterURL = "https://image.tmdb.org/t/p/w500${artist?.profilePath}"
        Glide.with(binding.imageView.context)
            .load(posterURL)
            .into(binding.imageView)
    }
}