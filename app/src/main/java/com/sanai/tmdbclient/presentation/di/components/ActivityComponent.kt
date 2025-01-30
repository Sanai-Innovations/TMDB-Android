package com.sanai.tmdbclient.presentation.di.components

import com.sanai.tmdbclient.presentation.di.modules.ActivityModule
import com.sanai.tmdbclient.presentation.di.scope.ActivityScope
import com.sanai.tmdbclient.presentation.ui.artists.ArtistsActivity
import com.sanai.tmdbclient.presentation.ui.movies.MoviesActivity
import com.sanai.tmdbclient.presentation.ui.tv_shows.TvShowsActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {
    fun inject(activity: MoviesActivity)
    fun inject(activity: TvShowsActivity)
    fun inject(activity: ArtistsActivity)
}