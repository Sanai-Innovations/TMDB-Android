package com.sanai.tmdbclient.domain.repository

import com.sanai.tmdbclient.data.model.artist.Artist

interface ArtistsRepository {
    suspend fun getArtists(): List<Artist>?
    suspend fun updateArtists(): List<Artist>?
}