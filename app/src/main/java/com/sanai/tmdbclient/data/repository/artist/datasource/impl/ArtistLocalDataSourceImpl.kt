package com.sanai.tmdbclient.data.repository.artist.datasource.impl

import android.util.Log
import com.sanai.tmdbclient.data.db.doa.ArtistsDao
import com.sanai.tmdbclient.data.model.artist.Artist
import com.sanai.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource

class ArtistLocalDataSourceImpl(private val artistDao: ArtistsDao) : ArtistLocalDataSource {
    override suspend fun deleteArtists() {
        Log.i("Anurag", "Delete artists from database")
        artistDao.deleteArtists()
    }

    override suspend fun getArtists(): List<Artist> {
        Log.i("Anurag", "Get artists from database")
        return artistDao.getArtists()
    }

    override suspend fun saveArtists(artists: List<Artist>) {
        Log.i("Anurag", "Save artists into database")
        artistDao.saveArtists(artists)
    }
}