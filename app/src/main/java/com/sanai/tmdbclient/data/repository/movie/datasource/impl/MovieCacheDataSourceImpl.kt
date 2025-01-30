package com.sanai.tmdbclient.data.repository.movie.datasource.impl

import com.sanai.tmdbclient.data.model.movie.Movie
import com.sanai.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource

class MovieCacheDataSourceImpl : MovieCacheDataSource {
    private var moviesData = ArrayList<Movie>()

    override fun saveMoviesToCache(movies: List<Movie>) {
        moviesData = ArrayList(movies)
    }

    override fun getMoviesFromCache(): List<Movie> = moviesData
}