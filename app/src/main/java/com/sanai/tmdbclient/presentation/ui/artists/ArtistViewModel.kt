package com.sanai.tmdbclient.presentation.ui.artists

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.sanai.tmdbclient.domain.use_cases.GetArtistsUseCase
import com.sanai.tmdbclient.domain.use_cases.UpdateArtistsUseCase

class ArtistViewModel(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
) : ViewModel() {

    fun getArtists() = liveData {
        val artists = getArtistsUseCase.execute()
        emit(artists)
    }

    fun updateArtists() = liveData {
        val artists = updateArtistsUseCase.execute()
        emit(artists)
    }
}