package com.sanai.tmdbclient.presentation.di.modules

import com.sanai.tmdbclient.data.db.doa.ArtistsDao
import com.sanai.tmdbclient.data.db.doa.MoviesDao
import com.sanai.tmdbclient.data.db.doa.TvShowsDao
import com.sanai.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.sanai.tmdbclient.data.repository.artist.datasource.impl.ArtistLocalDataSourceImpl
import com.sanai.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.sanai.tmdbclient.data.repository.movie.datasource.impl.MovieLocalDataSourceImpl
import com.sanai.tmdbclient.data.repository.tv_show.datasource.TvShowLocalDataSource
import com.sanai.tmdbclient.data.repository.tv_show.datasource.impl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMoviesLocalDataSource(moviesDao: MoviesDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(moviesDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowsDao: TvShowsDao): TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(tvShowsDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistsDao: ArtistsDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistsDao)
    }
}