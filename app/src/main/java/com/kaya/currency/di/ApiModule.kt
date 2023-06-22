package com.kaya.currency.di

import android.util.Log
import com.kaya.currency.MainApplication
import com.kaya.currency.R
import com.kaya.currency.core.api.core.adapters.factories.LiveDataCallAdapterFactory
import com.kaya.currency.core.api.interfaces.CurrencyService
import com.kaya.currency.core.api.interfaces.OkHTTPClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    @Singleton
    fun provideRetrofit(
        application: MainApplication,
        okHTTPClient: OkHTTPClient,
    ): CurrencyService {
        Log.d("atakaya", "get retro")
        return Retrofit.Builder()
            .baseUrl(application.getString(R.string.base_url))
            .client(okHTTPClient.getUnsafeOkHTTPClient())
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CurrencyService::class.java)
    }
}