package com.kaya.currency.core.api.models.responses

import com.google.gson.annotations.SerializedName


data class CoinsResponseStats (

  @SerializedName("total"          ) var total          : Int?    = null,
  @SerializedName("totalCoins"     ) var totalCoins     : Int?    = null,
  @SerializedName("totalMarkets"   ) var totalMarkets   : Int?    = null,
  @SerializedName("totalExchanges" ) var totalExchanges : Int?    = null,
  @SerializedName("totalMarketCap" ) var totalMarketCap : String? = null,
  @SerializedName("total24hVolume" ) var total24hVolume : String? = null

)