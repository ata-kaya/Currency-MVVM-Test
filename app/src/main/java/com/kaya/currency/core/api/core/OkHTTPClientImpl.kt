package com.kaya.currency.core.api.core


import android.util.Log
import com.kaya.currency.BuildConfig
import com.kaya.currency.core.api.interfaces.OkHTTPClient
import okhttp3.OkHttpClient
import okhttp3.Request
import java.security.SecureRandom
import java.security.cert.X509Certificate
import javax.inject.Inject
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

class OkHTTPClientImpl @Inject constructor() : OkHTTPClient {
    override fun getUnsafeOkHTTPClient(): OkHttpClient {
        Log.d("atakaya", "getUnsafe")
        return OkHttpClient.Builder().apply {
            addInterceptor { chain ->
                val requestBuilder: Request.Builder = chain.request().newBuilder()

                // 'X-RapidAPI-Key': 'd513fba479msh425c19697c8daafp103cd5jsn7e58d8ac9ff8',
                //    'X-RapidAPI-Host': 'weatherapi-com.p.rapidapi.com'
                requestBuilder.addHeader("X-RapidAPI-Key", BuildConfig.XRapidAPIKey)
                requestBuilder.addHeader("X-RapidAPI-Host", BuildConfig.XRapidAPIHost)
                chain.proceed(requestBuilder.build())
            }

            try {
                val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {
                    override fun checkClientTrusted(
                        p0: Array<out X509Certificate>?, p1: String?
                    ) {
                    }

                    override fun checkServerTrusted(
                        p0: Array<out X509Certificate>?, p1: String?
                    ) {
                    }

                    override fun getAcceptedIssuers(): Array<X509Certificate> = arrayOf()

                })
                SSLContext.getInstance("TLS").apply {
                    init(null, trustAllCerts, SecureRandom())
                    sslSocketFactory(socketFactory, trustAllCerts[0] as X509TrustManager)
                    hostnameVerifier { hostname, session -> true }
                }

            } catch (e: Exception) {
                throw java.lang.RuntimeException(e)
            }
        }.build()
    }
}