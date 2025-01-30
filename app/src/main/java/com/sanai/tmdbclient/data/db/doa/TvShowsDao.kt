package com.sanai.tmdbclient.data.db.doa

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sanai.tmdbclient.data.model.tv_show.TvShow

@Dao
interface TvShowsDao {

    @Query("SELECT * FROM tv_show_table")
    suspend fun getTvShows(): List<TvShow>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShows(movies: List<TvShow>)

    @Query("DELETE FROM tv_show_table")
    suspend fun deleteTvShows()
}