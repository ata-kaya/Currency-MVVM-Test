package com.kaya.currency.core.api.core

import androidx.lifecycle.LiveData
import com.kaya.currency.core.api.interfaces.CurrencyService
import com.kaya.currency.core.api.models.responses.GetCoinsResponse
import javax.inject.Inject

class ApiClient @Inject constructor(
    private val currencyService: CurrencyService
) {
    fun getCoinsAPI(): LiveData<ApiResponse<GetCoinsResponse>> {
        return currencyService.getCoins()
    }
}