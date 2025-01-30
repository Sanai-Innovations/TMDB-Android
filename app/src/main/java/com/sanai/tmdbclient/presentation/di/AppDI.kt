package com.sanai.tmdbclient.presentation.di

import android.app.Activity
import android.content.Context
import com.sanai.tmdbclient.BuildConfig
import com.sanai.tmdbclient.presentation.di.components.ActivityComponent
import com.sanai.tmdbclient.presentation.di.components.ApplicationComponent
import com.sanai.tmdbclient.presentation.di.components.DaggerApplicationComponent
import com.sanai.tmdbclient.presentation.di.modules.ActivityModule
import com.sanai.tmdbclient.presentation.di.modules.AppModule
import com.sanai.tmdbclient.presentation.di.modules.NetworkModule
import com.sanai.tmdbclient.presentation.di.modules.RemoteDataModule

/**
 * Created a singleton class to create only one application component across
 * the application. Then created sub components for the activity level and
 * fragment level
 */
class AppDI {

    companion object {

        private var applicationComponent: ApplicationComponent? = null

        /**
         * we need to mention only those modules those having the constructors
         * as dagger does not know how to make it. We could also use the Factory
         * or Builder method to create these modules with constructors
         */
        fun getApplicationComponent(context: Context): ApplicationComponent {
            if (applicationComponent == null) {
                applicationComponent = DaggerApplicationComponent.builder()
                    .appModule(AppModule(context))
                    .networkModule(NetworkModule(BuildConfig.BASE_URL))
                    .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
                    .build()
            }
            return applicationComponent!!
        }

        /**
         * creating the sub component instance having the modules with constructors
         */
        fun getActivityComponent(activity: Activity): ActivityComponent {
            return getApplicationComponent(activity).plus(ActivityModule(activity))
        }
    }
}