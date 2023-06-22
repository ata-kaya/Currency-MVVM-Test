package com.kaya.currency.di

import android.content.Context
import com.kaya.currency.MainApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {
    @Provides
    fun provideMainApplication(@ApplicationContext context: Context): MainApplication {
        return context as MainApplication
    }
}