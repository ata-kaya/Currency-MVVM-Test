package com.kaya.currency.core.api.models.responses

import com.google.gson.annotations.SerializedName


data class CoinsResponseData (

    @SerializedName("stats" ) var stats : CoinsResponseStats?           = CoinsResponseStats(),
    @SerializedName("coins" ) var coins : ArrayList<Coins> = arrayListOf()

)