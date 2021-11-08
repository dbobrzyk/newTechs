package com.example.dookoff.di

import android.app.AppComponentFactory
import android.content.Context
import com.example.dookoff.activity.BaseApplication
import com.example.dookoff.networking.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.internal.managers.ApplicationComponentManager
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object TestAppModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext context: Context ): BaseApplication{
        return context as BaseApplication
    }

    @Singleton
    @Provides
    fun provideRandomString(): String{
        return "hth54yeg"
    }

    @Singleton
    @Provides
    fun provideRetrofit(): RetrofitClient{
        return RetrofitClient()
    }

}