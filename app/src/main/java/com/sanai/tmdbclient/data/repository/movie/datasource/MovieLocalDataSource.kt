package com.sanai.tmdbclient.data.repository.movie.datasource

import com.sanai.tmdbclient.data.model.movie.Movie

interface MovieLocalDataSource {

    suspend fun deleteMovies()
    suspend fun getMovies(): List<Movie>
    suspend fun saveMovies(movies: List<Movie>)
}