package com.sanai.tmdbclient.presentation.ui.movies

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sanai.tmdbclient.R
import com.sanai.tmdbclient.databinding.ActivityMoviesBinding
import com.sanai.tmdbclient.presentation.di.AppDI
import javax.inject.Inject

class MoviesActivity : AppCompatActivity() {

    private lateinit var adapter: MoviesAdapter
    private lateinit var viewModel: MovieViewModel
    private lateinit var binding: ActivityMoviesBinding

    @Inject
    lateinit var viewModelFactory: MovieViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppDI.getActivityComponent(this).inject(this)
        initializeVariables()
        observeData()
    }

    private fun observeData() {
        binding.movieProgressBar.visibility = View.VISIBLE
        val responseLiveData = viewModel.getMovies()
        responseLiveData.observe(this) {

            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility = View.GONE
            } else {
                binding.movieProgressBar.visibility = View.GONE
                Toast.makeText(this, "No data available", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun initializeVariables() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movies)
        viewModel = ViewModelProvider.create(this, viewModelFactory)[MovieViewModel::class]
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.movieRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.movieRecyclerView.hasFixedSize()
        adapter = MoviesAdapter()
        binding.movieRecyclerView.adapter = adapter
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
        binding.movieProgressBar.visibility = View.VISIBLE
        val response = viewModel.updateMovies()
        response.observe(this) {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility = View.GONE
            } else {
                binding.movieProgressBar.visibility = View.GONE
                Toast.makeText(this, "No data available", Toast.LENGTH_SHORT).show()
            }
        }
    }
}