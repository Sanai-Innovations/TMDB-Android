package com.sanai.tmdbclient.data.repository.tv_show.datasource.impl

import com.sanai.tmdbclient.data.model.tv_show.TvShow
import com.sanai.tmdbclient.data.repository.tv_show.datasource.TvShowCacheDataSource

class TvShowCacheDataSourceImpl : TvShowCacheDataSource {
    private var tvShowsData = ArrayList<TvShow>()

    override fun saveTvShowsToCache(tvShows: List<TvShow>) {
        tvShowsData = ArrayList(tvShows)
    }

    override fun getTvShowsFromCache(): List<TvShow> = tvShowsData
}