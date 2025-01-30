package com.sanai.tmdbclient.domain.use_cases

import com.sanai.tmdbclient.data.model.artist.Artist
import com.sanai.tmdbclient.domain.repository.ArtistsRepository

class UpdateArtistsUseCase(private val repository: ArtistsRepository) {
    suspend fun execute(): List<Artist>? = repository.updateArtists()
}