package com.sanai.tmdbclient.data.repository.artist.datasource

import com.sanai.tmdbclient.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtists(): Response<ArtistList>
}