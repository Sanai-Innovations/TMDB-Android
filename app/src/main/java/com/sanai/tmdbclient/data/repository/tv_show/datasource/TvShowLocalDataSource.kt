package com.sanai.tmdbclient.data.repository.tv_show.datasource

import com.sanai.tmdbclient.data.model.tv_show.TvShow

interface TvShowLocalDataSource {

    suspend fun deleteTvShows()
    suspend fun getTvShows(): List<TvShow>
    suspend fun saveTvShows(tvShows: List<TvShow>)
}