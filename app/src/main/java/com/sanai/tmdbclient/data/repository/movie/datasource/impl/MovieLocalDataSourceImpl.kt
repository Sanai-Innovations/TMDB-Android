package com.sanai.tmdbclient.data.repository.movie.datasource.impl

import android.util.Log
import com.sanai.tmdbclient.data.db.doa.MoviesDao
import com.sanai.tmdbclient.data.model.movie.Movie
import com.sanai.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource

class MovieLocalDataSourceImpl(private val moviesDao: MoviesDao) : MovieLocalDataSource {
    override suspend fun deleteMovies() {
        Log.i("Anurag", "Delete movies from database")
        moviesDao.deleteMovies()
    }

    override suspend fun getMovies(): List<Movie> {
        Log.i("Anurag", "Get movies from database")
        return moviesDao.getMovies()
    }

    override suspend fun saveMovies(movies: List<Movie>) {
        Log.i("Anurag", "Save movies to database")
        moviesDao.saveMovies(movies)
    }
}