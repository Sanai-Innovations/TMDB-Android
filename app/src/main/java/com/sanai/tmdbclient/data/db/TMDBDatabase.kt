package com.sanai.tmdbclient.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sanai.tmdbclient.data.db.doa.ArtistsDao
import com.sanai.tmdbclient.data.db.doa.MoviesDao
import com.sanai.tmdbclient.data.db.doa.TvShowsDao
import com.sanai.tmdbclient.data.model.artist.Artist
import com.sanai.tmdbclient.data.model.movie.Movie
import com.sanai.tmdbclient.data.model.tv_show.TvShow

@Database(
    entities = [Movie::class, TvShow::class, Artist::class],
    version = 1,
    exportSchema = false
)
abstract class TMDBDatabase : RoomDatabase() {

    abstract fun getMoviesDao(): MoviesDao
    abstract fun getTvShowsDao(): TvShowsDao
    abstract fun getArtistsDao(): ArtistsDao
}