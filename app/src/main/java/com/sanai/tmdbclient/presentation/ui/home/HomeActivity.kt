package com.sanai.tmdbclient.presentation.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.sanai.tmdbclient.R
import com.sanai.tmdbclient.databinding.ActivityHomeBinding
import com.sanai.tmdbclient.presentation.ui.artists.ArtistsActivity
import com.sanai.tmdbclient.presentation.ui.movies.MoviesActivity
import com.sanai.tmdbclient.presentation.ui.tv_shows.TvShowsActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        binding.btnMovies.setOnClickListener {
            startActivity(Intent(this, MoviesActivity::class.java))
        }

        binding.btnTvShows.setOnClickListener {
            startActivity(Intent(this, TvShowsActivity::class.java))
        }

        binding.btnArtists.setOnClickListener {
            startActivity(Intent(this, ArtistsActivity::class.java))
        }
    }
}