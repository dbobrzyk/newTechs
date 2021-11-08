package com.example.dookoff.di

import com.example.dookoff.data.FakeCatRepository
import com.example.dookoff.networking.CatRepository
import com.example.dookoff.networking.CatRepositoryImpl
import com.example.dookoff.networking.CatService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TestRepositoryModule {

    @Singleton
    @Provides
    fun provideCatRepositoryForTest(): FakeCatRepository {
        return FakeCatRepository()
    }

}