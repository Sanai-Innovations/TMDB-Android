package com.sanai.tmdbclient.presentation.di.modules

import com.sanai.tmdbclient.domain.repository.ArtistsRepository
import com.sanai.tmdbclient.domain.repository.MoviesRepository
import com.sanai.tmdbclient.domain.repository.TvShowsRepository
import com.sanai.tmdbclient.domain.use_cases.GetArtistsUseCase
import com.sanai.tmdbclient.domain.use_cases.GetMoviesUseCase
import com.sanai.tmdbclient.domain.use_cases.GetTvShowsUseCase
import com.sanai.tmdbclient.domain.use_cases.UpdateArtistsUseCase
import com.sanai.tmdbclient.domain.use_cases.UpdateMoviesUseCase
import com.sanai.tmdbclient.domain.use_cases.UpdateTvShowsUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetMovieUseCase(repository: MoviesRepository): GetMoviesUseCase {
        return GetMoviesUseCase(repository)
    }

    @Provides
    fun provideGetTvShowUseCase(repository: TvShowsRepository): GetTvShowsUseCase {
        return GetTvShowsUseCase(repository)
    }

    @Provides
    fun provideGetArtistUseCase(repository: ArtistsRepository): GetArtistsUseCase {
        return GetArtistsUseCase(repository)
    }

    @Provides
    fun provideUpdateMovieUseCase(repository: MoviesRepository): UpdateMoviesUseCase {
        return UpdateMoviesUseCase(repository)
    }

    @Provides
    fun provideUpdateTvShowUseCase(repository: TvShowsRepository): UpdateTvShowsUseCase {
        return UpdateTvShowsUseCase(repository)
    }

    @Provides
    fun provideUpdateArtistUseCase(repository: ArtistsRepository): UpdateArtistsUseCase {
        return UpdateArtistsUseCase(repository)
    }
}