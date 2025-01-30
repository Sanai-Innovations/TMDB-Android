package com.sanai.tmdbclient.presentation.di.modules

import com.sanai.tmdbclient.data.repository.artist.ArtistsRepositoryImpl
import com.sanai.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.sanai.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.sanai.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.sanai.tmdbclient.data.repository.movie.MoviesRepositoryImpl
import com.sanai.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.sanai.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.sanai.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.sanai.tmdbclient.data.repository.tv_show.TvShowRepositoryImpl
import com.sanai.tmdbclient.data.repository.tv_show.datasource.TvShowCacheDataSource
import com.sanai.tmdbclient.data.repository.tv_show.datasource.TvShowLocalDataSource
import com.sanai.tmdbclient.data.repository.tv_show.datasource.TvShowRemoteDataSource
import com.sanai.tmdbclient.domain.repository.ArtistsRepository
import com.sanai.tmdbclient.domain.repository.MoviesRepository
import com.sanai.tmdbclient.domain.repository.TvShowsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun providesMovieRepository(
        localDataSource: MovieLocalDataSource,
        remoteDataSource: MovieRemoteDataSource,
        cacheDataSource: MovieCacheDataSource
    ): MoviesRepository {
        return MoviesRepositoryImpl(cacheDataSource, localDataSource, remoteDataSource)
    }

    @Singleton
    @Provides
    fun providesArtisRepository(
        localDataSource: ArtistLocalDataSource,
        remoteDataSource: ArtistRemoteDataSource,
        cacheDataSource: ArtistCacheDataSource
    ): ArtistsRepository {
        return ArtistsRepositoryImpl(cacheDataSource, localDataSource, remoteDataSource)
    }

    @Singleton
    @Provides
    fun providesTvShowRepository(
        localDataSource: TvShowLocalDataSource,
        remoteDataSource: TvShowRemoteDataSource,
        cacheDataSource: TvShowCacheDataSource
    ): TvShowsRepository {
        return TvShowRepositoryImpl(cacheDataSource, localDataSource, remoteDataSource)
    }
}