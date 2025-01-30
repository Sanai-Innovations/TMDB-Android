package com.sanai.tmdbclient.data.repository.movie

import android.util.Log
import com.sanai.tmdbclient.data.model.movie.Movie
import com.sanai.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.sanai.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.sanai.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.sanai.tmdbclient.domain.repository.MoviesRepository

class MoviesRepositoryImpl(
    private val cacheDataSource: MovieCacheDataSource,
    private val localDataSource: MovieLocalDataSource,
    private val remoteDataSource: MovieRemoteDataSource
) : MoviesRepository {

    override suspend fun getMovies(): List<Movie> {
        Log.i("Anurag", "Thread ${Thread.currentThread()}")
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie> {
        val movies = getMoviesFromAPI()
        localDataSource.deleteMovies()
        localDataSource.saveMovies(movies)
        cacheDataSource.saveMoviesToCache(movies)
        return movies
    }

    private suspend fun getMoviesFromAPI(): List<Movie> {
        var movieList: List<Movie> = emptyList()
        try {
            val response = remoteDataSource.getMovies()
            Log.i("Anurag", "Fetched from API")
            if (response.body() != null) {
                movieList = response.body()!!.results
            }
        } catch (exception: Exception) {
            Log.i("Anurag", "Exception while fetching movies from API: ${exception.message}")
        }
        return movieList
    }

    private suspend fun getMoviesFromDatabase(): List<Movie> {
        var movieList: List<Movie> = emptyList()
        try {
            movieList = localDataSource.getMovies()
            if (movieList.isEmpty()) {
                movieList = getMoviesFromAPI()
                localDataSource.saveMovies(movieList)
            } else {
                Log.i("Anurag", "Fetched from database")
            }
        } catch (exception: Exception) {
            Log.i("Anurag", "Exception while fetching movies from Database: ${exception.message}")
        }
        return movieList
    }

    private suspend fun getMoviesFromCache(): List<Movie> {
        var movieList: List<Movie> = emptyList()
        try {
            movieList = cacheDataSource.getMoviesFromCache()
            if (movieList.isEmpty()) {
                movieList = getMoviesFromDatabase()
                cacheDataSource.saveMoviesToCache(movieList)
            } else {
                Log.i("Anurag", "Fetched from cache")
            }
        } catch (exception: Exception) {
            Log.i("Anurag", "Exception while fetching movies from Cache: ${exception.message}")
        }
        return movieList
    }
}