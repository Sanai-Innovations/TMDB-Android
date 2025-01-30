package com.sanai.tmdbclient.presentation.ui.tv_shows

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
import com.sanai.tmdbclient.databinding.ActivityTvShowsBinding
import com.sanai.tmdbclient.presentation.di.AppDI
import javax.inject.Inject

class TvShowsActivity : AppCompatActivity() {
    private lateinit var adapter: TvShowsAdapter
    private lateinit var viewModel: TvShowViewModel
    private lateinit var binding: ActivityTvShowsBinding

    @Inject
    lateinit var viewModelFactory: TvShowViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppDI.getActivityComponent(this).inject(this)
        initializeVariables()
        observeData()
    }

    private fun observeData() {
        binding.tvShowProgressBar.visibility = View.VISIBLE
        val responseLiveData = viewModel.getTvShows()
        responseLiveData.observe(this) {
            Log.d("Anurag", "TvShows $it")

            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.tvShowProgressBar.visibility = View.GONE
            } else {
                binding.tvShowProgressBar.visibility = View.GONE
                Toast.makeText(this, "No data available", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun initializeVariables() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_shows)
        viewModel = ViewModelProvider.create(this, viewModelFactory)[TvShowViewModel::class]
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.tvShowRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.tvShowRecyclerView.hasFixedSize()
        adapter = TvShowsAdapter()
        binding.tvShowRecyclerView.adapter = adapter
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
        binding.tvShowProgressBar.visibility = View.VISIBLE
        val response = viewModel.updateTvShows()
        response.observe(this) {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.tvShowProgressBar.visibility = View.GONE
            } else {
                binding.tvShowProgressBar.visibility = View.GONE
                Toast.makeText(this, "No data available", Toast.LENGTH_SHORT).show()
            }
        }
    }
}