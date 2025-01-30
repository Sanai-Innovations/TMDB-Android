package com.sanai.tmdbclient.data.api

import com.sanai.tmdbclient.data.model.movie.MovieList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("/3/movie/popular")
    suspend fun getMovies(@Query("api_key") apiKey: String): Response<MovieList>
}