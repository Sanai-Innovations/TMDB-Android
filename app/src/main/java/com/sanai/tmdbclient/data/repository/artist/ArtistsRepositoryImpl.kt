package com.sanai.tmdbclient.data.repository.artist

import android.util.Log
import com.sanai.tmdbclient.data.model.artist.Artist
import com.sanai.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.sanai.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.sanai.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.sanai.tmdbclient.domain.repository.ArtistsRepository

class ArtistsRepositoryImpl(
    private val cacheDataSource: ArtistCacheDataSource,
    private val localDataSource: ArtistLocalDataSource,
    private val remoteDataSource: ArtistRemoteDataSource
) : ArtistsRepository {

    override suspend fun getArtists(): List<Artist> {
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist> {
        val artists = getArtistsFromAPI()
        localDataSource.deleteArtists()
        localDataSource.saveArtists(artists)
        cacheDataSource.saveArtistsToCache(artists)
        return artists
    }

    private suspend fun getArtistsFromAPI(): List<Artist> {
        var artistList: List<Artist> = emptyList()
        try {
            val response = remoteDataSource.getArtists()
            if (response.body() != null) {
                artistList = response.body()!!.results
            }
        } catch (exception: Exception) {
            Log.i("Anurag", "Exception fetching artists from API ${exception.message}")
        }
        return artistList
    }

    private suspend fun getArtistsFromDatabase(): List<Artist> {
        var artistList: List<Artist> = emptyList()
        try {
            artistList = localDataSource.getArtists()
            if (artistList.isEmpty()) {
                artistList = getArtistsFromAPI()
                localDataSource.saveArtists(artistList)
            }
        } catch (exception: Exception) {
            Log.i("Anurag", "Exception fetching artists from Database ${exception.message}")
        }
        return artistList
    }

    private suspend fun getArtistsFromCache(): List<Artist> {
        var artistList: List<Artist> = emptyList()
        try {
            artistList = cacheDataSource.getArtistsFromCache()
            if (artistList.isEmpty()) {
                artistList = getArtistsFromDatabase()
                cacheDataSource.saveArtistsToCache(artistList)
            }
        } catch (exception: Exception) {
            Log.i("Anurag", "Exception fetching artists from Cache ${exception.message}")
        }
        return artistList
    }
}