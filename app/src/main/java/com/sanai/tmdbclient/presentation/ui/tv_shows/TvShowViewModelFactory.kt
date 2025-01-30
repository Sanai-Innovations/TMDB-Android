package com.sanai.tmdbclient.presentation.ui.tv_shows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sanai.tmdbclient.domain.use_cases.GetTvShowsUseCase
import com.sanai.tmdbclient.domain.use_cases.UpdateTvShowsUseCase
import javax.inject.Inject

class TvShowViewModelFactory @Inject constructor(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvShowViewModel(getTvShowsUseCase, updateTvShowsUseCase) as T
    }
}