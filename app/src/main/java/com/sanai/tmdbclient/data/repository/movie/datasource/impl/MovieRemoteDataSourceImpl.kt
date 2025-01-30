package com.sanai.tmdbclient.data.repository.movie.datasource.impl

import android.util.Log
import com.sanai.tmdbclient.data.api.MovieService
import com.sanai.tmdbclient.data.model.movie.MovieList
import com.sanai.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val apiKey: String,
    private val movieService: MovieService
) : MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> {
        Log.i("Anurag", "Thread 4 ${Thread.currentThread()}")
        return movieService.getMovies(apiKey)
    }
}