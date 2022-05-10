package com.example.hotplenavigation.di

import com.example.hotplenavigation.network.NaverMapApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {
    private const val baseGetResultPathURL = "https://naveropenapi.apigw.ntruss.com/map-direction/"
    private const val baseReverseGeoURL = "https://naveropenapi.apigw.ntruss.com/map-reversegeocode/"

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class GetResultPathType

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class ReverseGeoType

    @Singleton
    @Provides
    @GetResultPathType
    fun provideGetRetroServiceInterfaceGetResultPath(
        @GetResultPathType retrofit: Retrofit
    ): NaverMapApi =
        retrofit.create(NaverMapApi::class.java)

    @Singleton
    @Provides
    @GetResultPathType
    fun provideGetRetroInstanceGetResultPath(): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseGetResultPathURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Singleton
    @Provides
    @ReverseGeoType
    fun provideGetRetroServiceInterfaceReverseGeo(
        @ReverseGeoType retrofit: Retrofit
    ): NaverMapApi =
        retrofit.create(NaverMapApi::class.java)

    @Singleton
    @Provides
    @ReverseGeoType
    fun provideGetRetroInstanceReverseGeo(): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseReverseGeoURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}