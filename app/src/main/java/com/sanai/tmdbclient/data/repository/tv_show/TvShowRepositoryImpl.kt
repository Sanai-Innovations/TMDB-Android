package com.sanai.tmdbclient.data.repository.tv_show

import android.util.Log
import com.sanai.tmdbclient.data.model.tv_show.TvShow
import com.sanai.tmdbclient.data.repository.tv_show.datasource.TvShowCacheDataSource
import com.sanai.tmdbclient.data.repository.tv_show.datasource.TvShowLocalDataSource
import com.sanai.tmdbclient.data.repository.tv_show.datasource.TvShowRemoteDataSource
import com.sanai.tmdbclient.domain.repository.TvShowsRepository

class TvShowRepositoryImpl(
    private val cacheDataSource: TvShowCacheDataSource,
    private val localDataSource: TvShowLocalDataSource,
    private val remoteDataSource: TvShowRemoteDataSource
) : TvShowsRepository {

    override suspend fun getTvShows(): List<TvShow> {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow> {
        val tvShows = getTvShowsFromAPI()
        localDataSource.deleteTvShows()
        localDataSource.saveTvShows(tvShows)
        cacheDataSource.saveTvShowsToCache(tvShows)
        return tvShows
    }

    private suspend fun getTvShowsFromAPI(): List<TvShow> {
        var tvShowList: List<TvShow> = emptyList()
        try {
            val response = remoteDataSource.getTvShows()
            if (response.body() != null) {
                tvShowList = response.body()!!.results
            }
        } catch (exception: Exception) {
            Log.i("Anurag", "Exception fetching Tv Shows from API ${exception.message}")
        }
        return tvShowList
    }

    private suspend fun getTvShowsFromDatabase(): List<TvShow> {
        var tvShowList: List<TvShow> = emptyList()
        try {
            tvShowList = localDataSource.getTvShows()
            if (tvShowList.isEmpty()) {
                tvShowList = getTvShowsFromAPI()
                localDataSource.saveTvShows(tvShowList)
            }
        } catch (exception: Exception) {
            Log.i("Anurag", "Exception fetching Tv Shows from Database ${exception.message}")
        }
        return tvShowList
    }

    private suspend fun getTvShowsFromCache(): List<TvShow> {
        var tvShowList: List<TvShow> = emptyList()
        try {
            tvShowList = cacheDataSource.getTvShowsFromCache()
            if (tvShowList.isEmpty()) {
                tvShowList = getTvShowsFromDatabase()
                cacheDataSource.saveTvShowsToCache(tvShowList)
            }
        } catch (exception: Exception) {
            Log.i("Anurag", "Exception fetching tvShows from Cache ${exception.message}")
        }
        return tvShowList
    }
}