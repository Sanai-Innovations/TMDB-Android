package com.sanai.tmdbclient.presentation.di.modules

import android.content.Context
import androidx.room.Room
import com.sanai.tmdbclient.data.db.TMDBDatabase
import com.sanai.tmdbclient.data.db.doa.ArtistsDao
import com.sanai.tmdbclient.data.db.doa.MoviesDao
import com.sanai.tmdbclient.data.db.doa.TvShowsDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun getRoomDatabase(context: Context): TMDBDatabase =
        Room.databaseBuilder(context, TMDBDatabase::class.java, "tmdb-database")
            .build()

    @Singleton
    @Provides
    fun getMovieDao(database: TMDBDatabase): MoviesDao = database.getMoviesDao()

    @Singleton
    @Provides
    fun getTvShowDao(database: TMDBDatabase): TvShowsDao = database.getTvShowsDao()

    @Singleton
    @Provides
    fun getArtistDao(database: TMDBDatabase): ArtistsDao = database.getArtistsDao()
}