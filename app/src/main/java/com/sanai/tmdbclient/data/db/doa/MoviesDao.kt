package com.sanai.tmdbclient.data.db.doa

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sanai.tmdbclient.data.model.movie.Movie

@Dao
interface MoviesDao {

    @Query("SELECT * FROM movie_table")
    suspend fun getMovies(): List<Movie>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies: List<Movie>)

    @Query("DELETE FROM movie_table")
    suspend fun deleteMovies()
}