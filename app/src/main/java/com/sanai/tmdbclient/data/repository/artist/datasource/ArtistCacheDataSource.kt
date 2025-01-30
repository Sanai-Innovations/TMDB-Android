package com.sanai.tmdbclient.data.repository.artist.datasource

import com.sanai.tmdbclient.data.model.artist.Artist

interface ArtistCacheDataSource {

    fun getArtistsFromCache(): List<Artist>
    fun saveArtistsToCache(artists: List<Artist>)
}