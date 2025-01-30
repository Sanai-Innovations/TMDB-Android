package com.sanai.tmdbclient.presentation.ui.artists

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sanai.tmdbclient.R
import com.sanai.tmdbclient.databinding.ActivityArtistsBinding
import com.sanai.tmdbclient.presentation.di.AppDI
import javax.inject.Inject

class ArtistsActivity : AppCompatActivity() {
    private lateinit var adapter: ArtistsAdapter
    private lateinit var viewModel: ArtistViewModel
    private lateinit var binding: ActivityArtistsBinding

    @Inject
    lateinit var viewModelFactory: ArtistViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppDI.getActivityComponent(this).inject(this)
        initializeVariables()
        observeData()
    }

    private fun observeData() {
        binding.artistProgressBar.visibility = View.VISIBLE
        val responseLiveData = viewModel.getArtists()
        responseLiveData.observe(this) {
            Log.d("Anurag", "Artists ${it.toString()}")

            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.artistProgressBar.visibility = View.GONE
            } else {
                binding.artistProgressBar.visibility = View.GONE
                Toast.makeText(this, "No data available", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun initializeVariables() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_artists)
        viewModel = ViewModelProvider.create(this, viewModelFactory)[ArtistViewModel::class]
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.artistRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.artistRecyclerView.hasFixedSize()
        adapter = ArtistsAdapter()
        binding.artistRecyclerView.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_update) {
            updateMovies()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun updateMovies() {
        binding.artistProgressBar.visibility = View.VISIBLE
        val response = viewModel.updateArtists()
        response.observe(this) {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.artistProgressBar.visibility = View.GONE
            } else {
                binding.artistProgressBar.visibility = View.GONE
                Toast.makeText(this, "No data available", Toast.LENGTH_SHORT).show()
            }
        }
    }
}