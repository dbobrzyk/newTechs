package com.example.dookoff.di

import android.app.Application
import com.example.dookoff.networking.CatService
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object TestNetworkModule {

//    @Singleton
//    @Provides
//    fun provideCatServiceForTest(): CatService{
//        val interceptor = HttpLoggingInterceptor()
//        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
//        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
//
//        return Retrofit.Builder().baseUrl(CatService.URL)
//            .addConverterFactory(MoshiConverterFactory.create())
//            .client(client)
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//            .addCallAdapterFactory(CoroutineCallAdapterFactory() )
//            .build()
//            .create(CatService::class.java)
//    }
}