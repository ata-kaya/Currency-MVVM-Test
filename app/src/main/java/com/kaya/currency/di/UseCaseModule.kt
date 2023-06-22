package com.kaya.currency.di

import com.kaya.currency.core.api.core.ApiClient
import com.kaya.currency.domain.use_case.GetCoinUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideGetCoinsUseCase(apiClient: ApiClient): GetCoinUseCase = GetCoinUseCase(apiClient)
}