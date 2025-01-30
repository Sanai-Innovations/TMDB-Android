package com.sanai.tmdbclient.presentation.ui.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sanai.tmdbclient.domain.use_cases.GetMoviesUseCase
import com.sanai.tmdbclient.domain.use_cases.UpdateMoviesUseCase
import javax.inject.Inject

class MovieViewModelFactory @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieViewModel(getMoviesUseCase, updateMoviesUseCase) as T
    }
}