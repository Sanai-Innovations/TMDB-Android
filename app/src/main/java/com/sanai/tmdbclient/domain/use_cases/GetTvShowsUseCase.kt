package com.sanai.tmdbclient.domain.use_cases

import com.sanai.tmdbclient.data.model.tv_show.TvShow
import com.sanai.tmdbclient.domain.repository.TvShowsRepository

class GetTvShowsUseCase(private val repository: TvShowsRepository) {
    suspend fun execute(): List<TvShow> = repository.getTvShows()
}