package com.kaya.currency.domain.use_case

import androidx.lifecycle.LiveData
import com.kaya.currency.core.api.core.ApiClient
import com.kaya.currency.core.api.core.ApiResponse
import com.kaya.currency.core.api.models.responses.GetCoinsResponse
import com.kaya.currency.core.use_case.UseCase
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val apiClient: ApiClient
) : UseCase<LiveData<ApiResponse<GetCoinsResponse>>>() {
    override fun execute(): LiveData<ApiResponse<GetCoinsResponse>> {
        return apiClient.getCoinsAPI()
    }
}