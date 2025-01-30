package com.sanai.tmdbclient.data.repository.tv_show.datasource.impl

import com.sanai.tmdbclient.data.db.doa.TvShowsDao
import com.sanai.tmdbclient.data.model.tv_show.TvShow
import com.sanai.tmdbclient.data.repository.tv_show.datasource.TvShowLocalDataSource

class TvShowLocalDataSourceImpl(private val tvShowDao: TvShowsDao) : TvShowLocalDataSource {
    override suspend fun deleteTvShows() = tvShowDao.deleteTvShows()
    override suspend fun getTvShows(): List<TvShow> = tvShowDao.getTvShows()
    override suspend fun saveTvShows(tvShows: List<TvShow>) = tvShowDao.saveTvShows(tvShows)
}