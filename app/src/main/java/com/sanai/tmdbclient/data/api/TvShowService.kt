package com.sanai.tmdbclient.data.api

import com.sanai.tmdbclient.data.model.tv_show.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TvShowService {

    @GET("/3/tv/popular")
    suspend fun getTvShows(@Query("api_key") apiKey: String): Response<TvShowList>
}