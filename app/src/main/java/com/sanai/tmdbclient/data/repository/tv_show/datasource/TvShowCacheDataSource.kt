package com.sanai.tmdbclient.data.repository.tv_show.datasource

import com.sanai.tmdbclient.data.model.tv_show.TvShow

interface TvShowCacheDataSource {

    fun getTvShowsFromCache(): List<TvShow>
    fun saveTvShowsToCache(tvShows: List<TvShow>)
}