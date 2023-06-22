package com.kaya.currency.core.api.interfaces

import okhttp3.OkHttpClient

interface OkHTTPClient {
    fun getUnsafeOkHTTPClient(): OkHttpClient
}