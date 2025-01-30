package com.sanai.tmdbclient.presentation.ui.artists

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sanai.tmdbclient.domain.use_cases.GetArtistsUseCase
import com.sanai.tmdbclient.domain.use_cases.UpdateArtistsUseCase
import javax.inject.Inject

class ArtistViewModelFactory @Inject constructor(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArtistViewModel(getArtistsUseCase, updateArtistsUseCase) as T
    }
}