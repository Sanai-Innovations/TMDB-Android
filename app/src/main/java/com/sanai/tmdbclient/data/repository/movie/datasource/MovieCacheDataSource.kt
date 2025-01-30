package com.sanai.tmdbclient.data.repository.movie.datasource

import com.sanai.tmdbclient.data.model.movie.Movie

interface MovieCacheDataSource {

    fun getMoviesFromCache(): List<Movie>
    fun saveMoviesToCache(movies: List<Movie>)
}