package com.sanai.tmdbclient.data.db.doa

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sanai.tmdbclient.data.model.artist.Artist

@Dao
interface ArtistsDao {

    @Query("SELECT * FROM artist_table")
    suspend fun getArtists(): List<Artist>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtists(artists: List<Artist>)

    @Query("DELETE FROM artist_table")
    suspend fun deleteArtists()
}