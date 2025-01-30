package com.sanai.tmdbclient.data.api

import com.sanai.tmdbclient.data.model.artist.ArtistList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ArtistService {

    @GET("/3/person/popular")
    suspend fun getArtists(@Query("api_key") apiKey: String): Response<ArtistList>
}