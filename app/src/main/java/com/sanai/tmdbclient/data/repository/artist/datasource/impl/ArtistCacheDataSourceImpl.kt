package com.sanai.tmdbclient.data.repository.artist.datasource.impl

import com.sanai.tmdbclient.data.model.artist.Artist
import com.sanai.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource

class ArtistCacheDataSourceImpl : ArtistCacheDataSource {
    private var artistsData = ArrayList<Artist>()

    override fun saveArtistsToCache(artists: List<Artist>) {
        artistsData = ArrayList(artists)
    }

    override fun getArtistsFromCache(): List<Artist> = artistsData
}