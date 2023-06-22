package com.kaya.currency.core.api.models.responses

import com.google.gson.annotations.SerializedName


data class GetCoinsResponse (

    @SerializedName("status" ) var status : String? = null,
    @SerializedName("data"   ) var data   : CoinsResponseData?   = CoinsResponseData()

)