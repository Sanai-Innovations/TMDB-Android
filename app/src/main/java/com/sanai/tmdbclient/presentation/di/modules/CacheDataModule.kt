package com.sanai.tmdbclient.presentation.di.modules

import com.sanai.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.sanai.tmdbclient.data.repository.artist.datasource.impl.ArtistCacheDataSourceImpl
import com.sanai.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.sanai.tmdbclient.data.repository.movie.datasource.impl.MovieCacheDataSourceImpl
import com.sanai.tmdbclient.data.repository.tv_show.datasource.TvShowCacheDataSource
import com.sanai.tmdbclient.data.repository.tv_show.datasource.impl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowCacheDataSource {
        return TvShowCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }
}