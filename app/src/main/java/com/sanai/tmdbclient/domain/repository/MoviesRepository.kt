package com.sanai.tmdbclient.domain.repository

import com.sanai.tmdbclient.data.model.movie.Movie

interface MoviesRepository {
    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies(): List<Movie>?
}