package com.sanai.tmdbclient.domain.use_cases

import com.sanai.tmdbclient.data.model.movie.Movie
import com.sanai.tmdbclient.domain.repository.MoviesRepository

class UpdateMoviesUseCase(private val repository: MoviesRepository) {
    suspend fun execute(): List<Movie>? = repository.updateMovies()
}