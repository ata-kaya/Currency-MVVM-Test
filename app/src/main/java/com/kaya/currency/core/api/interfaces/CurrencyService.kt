package com.kaya.currency.core.api.interfaces

import androidx.lifecycle.LiveData
import com.kaya.currency.core.api.APIs
import com.kaya.currency.core.api.core.ApiResponse
import com.kaya.currency.core.api.models.responses.GetCoinsResponse
import retrofit2.http.GET

interface CurrencyService {
    @GET(APIs.getCoins)
    fun getCoins(): LiveData<ApiResponse<GetCoinsResponse>>
}