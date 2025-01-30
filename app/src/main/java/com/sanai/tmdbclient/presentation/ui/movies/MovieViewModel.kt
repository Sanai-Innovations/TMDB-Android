package com.sanai.tmdbclient.presentation.ui.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.sanai.tmdbclient.domain.use_cases.GetMoviesUseCase
import com.sanai.tmdbclient.domain.use_cases.UpdateMoviesUseCase

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModel() {

    fun getMovies() = liveData {
        val movies = getMoviesUseCase.execute()
        emit(movies)
    }

    fun updateMovies() = liveData {
        val movies = updateMoviesUseCase.execute()
        emit(movies)
    }
}