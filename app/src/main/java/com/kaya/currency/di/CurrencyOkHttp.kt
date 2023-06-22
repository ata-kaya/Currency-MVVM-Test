package com.kaya.currency.di

import com.kaya.currency.core.api.core.OkHTTPClientImpl
import com.kaya.currency.core.api.interfaces.OkHTTPClient
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class CurrencyOkHttp {
    @Binds
    @Singleton
    abstract fun bindOkHttp(
        okHTTPClientImpl: OkHTTPClientImpl
    ): OkHTTPClient
}