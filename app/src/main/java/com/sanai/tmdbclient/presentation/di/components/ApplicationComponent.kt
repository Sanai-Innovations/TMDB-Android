package com.sanai.tmdbclient.presentation.di.components

import android.app.Application
import com.sanai.tmdbclient.presentation.di.modules.ActivityModule
import com.sanai.tmdbclient.presentation.di.modules.AppModule
import com.sanai.tmdbclient.presentation.di.modules.CacheDataModule
import com.sanai.tmdbclient.presentation.di.modules.DatabaseModule
import com.sanai.tmdbclient.presentation.di.modules.LocalDataModule
import com.sanai.tmdbclient.presentation.di.modules.NetworkModule
import com.sanai.tmdbclient.presentation.di.modules.RemoteDataModule
import com.sanai.tmdbclient.presentation.di.modules.RepositoryModule
import com.sanai.tmdbclient.presentation.di.modules.UseCaseModule
import dagger.Component
import javax.inject.Singleton

/**
 * created the application component which will live for the application life
 * have to mention the singleton here as we have some modules mentioned the scope
 * as singleton
 *
 * the modules/objects having different scope need to be created as sub component
 * like created below as activity component
 */
@Singleton
@Component(
    modules = [AppModule::class, CacheDataModule::class, DatabaseModule::class,
        LocalDataModule::class, NetworkModule::class, RemoteDataModule::class,
        RepositoryModule::class, UseCaseModule::class]
)
interface ApplicationComponent {
    fun plus(module: ActivityModule): ActivityComponent

    fun inject(application: Application)
}