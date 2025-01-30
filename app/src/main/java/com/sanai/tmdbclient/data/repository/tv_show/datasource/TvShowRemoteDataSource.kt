package com.sanai.tmdbclient.data.repository.tv_show.datasource

import com.sanai.tmdbclient.data.model.tv_show.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {
    suspend fun getTvShows(): Response<TvShowList>
}