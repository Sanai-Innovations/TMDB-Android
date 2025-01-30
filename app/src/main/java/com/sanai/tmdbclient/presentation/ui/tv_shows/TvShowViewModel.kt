package com.sanai.tmdbclient.presentation.ui.tv_shows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.sanai.tmdbclient.domain.use_cases.GetTvShowsUseCase
import com.sanai.tmdbclient.domain.use_cases.UpdateTvShowsUseCase

class TvShowViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
) : ViewModel() {

    fun getTvShows() = liveData {
        val tvShows = getTvShowsUseCase.execute()
        emit(tvShows)
    }

    fun updateTvShows() = liveData {
        val tvShows = updateTvShowsUseCase.execute()
        emit(tvShows)
    }
}