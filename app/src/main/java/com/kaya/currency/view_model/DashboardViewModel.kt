package com.kaya.currency.view_model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.kaya.currency.MainApplication
import com.kaya.currency.core.api.core.ApiSuccessResponse
import com.kaya.currency.core.api.models.responses.Coins
import com.kaya.currency.domain.use_case.GetCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val application: MainApplication,
    private val getCoinUseCase: GetCoinUseCase,
) : BaseViewModel() {

    val coins = MutableLiveData<ArrayList<Coins>>()

    fun getCoins(viewLifecycleOwner: androidx.lifecycle.LifecycleOwner) {
        Log.d("atakaya", "dashboardViewModel ")

        getCoinUseCase.execute().observe(viewLifecycleOwner) { response ->
            if (response is ApiSuccessResponse) {
                Log.d("atakaya", "data received")
                val data = response.body.data!!.coins
                coins.postValue(data)
            }
        }
    }
}