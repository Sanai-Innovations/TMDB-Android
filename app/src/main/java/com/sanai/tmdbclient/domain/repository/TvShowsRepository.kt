package com.sanai.tmdbclient.domain.repository

import com.sanai.tmdbclient.data.model.tv_show.TvShow

interface TvShowsRepository {
    suspend fun getTvShows(): List<TvShow>
    suspend fun updateTvShows(): List<TvShow>
}