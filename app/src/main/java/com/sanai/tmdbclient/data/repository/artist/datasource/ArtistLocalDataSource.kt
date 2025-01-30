package com.sanai.tmdbclient.data.repository.artist.datasource

import com.sanai.tmdbclient.data.model.artist.Artist

interface ArtistLocalDataSource {

    suspend fun deleteArtists()
    suspend fun getArtists(): List<Artist>
    suspend fun saveArtists(artists: List<Artist>)
}