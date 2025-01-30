package com.sanai.tmdbclient.data.repository.artist.datasource.impl

import android.util.Log
import com.sanai.tmdbclient.data.api.ArtistService
import com.sanai.tmdbclient.data.model.artist.ArtistList
import com.sanai.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val apiKey: String,
    private val artistService: ArtistService
) : ArtistRemoteDataSource {
    override suspend fun getArtists(): Response<ArtistList>{
        Log.i("Anurag", "Get artists from API")
        return artistService.getArtists(apiKey)
    }
}