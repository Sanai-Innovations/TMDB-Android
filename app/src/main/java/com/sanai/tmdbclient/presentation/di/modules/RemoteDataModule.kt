package com.sanai.tmdbclient.presentation.di.modules

import com.sanai.tmdbclient.data.api.ArtistService
import com.sanai.tmdbclient.data.api.MovieService
import com.sanai.tmdbclient.data.api.TvShowService
import com.sanai.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.sanai.tmdbclient.data.repository.artist.datasource.impl.ArtistRemoteDataSourceImpl
import com.sanai.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.sanai.tmdbclient.data.repository.movie.datasource.impl.MovieRemoteDataSourceImpl
import com.sanai.tmdbclient.data.repository.tv_show.datasource.TvShowRemoteDataSource
import com.sanai.tmdbclient.data.repository.tv_show.datasource.impl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(movieService: MovieService): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(apiKey, movieService)
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tvShowService: TvShowService): TvShowRemoteDataSource {
        return TvShowRemoteDataSourceImpl(apiKey, tvShowService)
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(artistService: ArtistService): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(apiKey, artistService)
    }
}