package com.sanai.tmdbclient.data.repository.tv_show.datasource.impl

import com.sanai.tmdbclient.data.api.TvShowService
import com.sanai.tmdbclient.data.model.tv_show.TvShowList
import com.sanai.tmdbclient.data.repository.tv_show.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
    private val apiKey: String,
    private val tvShowService: TvShowService
) : TvShowRemoteDataSource {
    override suspend fun getTvShows(): Response<TvShowList> = tvShowService.getTvShows(apiKey)
}