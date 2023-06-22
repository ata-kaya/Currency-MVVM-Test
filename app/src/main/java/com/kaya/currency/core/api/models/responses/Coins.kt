package com.kaya.currency.core.api.models.responses

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Coins (

  @SerializedName("uuid"           ) var uuid           : String?           = null,
  @SerializedName("symbol"         ) var symbol         : String?           = null,
  @SerializedName("name"           ) var name           : String?           = null,
  @SerializedName("color"          ) var color          : String?           = null,
  @SerializedName("iconUrl"        ) var iconUrl        : String?           = null,
  @SerializedName("marketCap"      ) var marketCap      : String?           = null,
  @SerializedName("price"          ) var price          : String?           = null,
  @SerializedName("listedAt"       ) var listedAt       : Int?              = null,
  @SerializedName("tier"           ) var tier           : Int?              = null,
  @SerializedName("change"         ) var change         : String?           = null,
  @SerializedName("rank"           ) var rank           : Int?              = null,
  @SerializedName("sparkline"      ) var sparkline      : ArrayList<String> = arrayListOf(),
  @SerializedName("lowVolume"      ) var lowVolume      : Boolean?          = null,
  @SerializedName("coinrankingUrl" ) var coinrankingUrl : String?           = null,
  @SerializedName("24hVolume"      ) var t24hVolume     : String?           = null,
  @SerializedName("btcPrice"       ) var btcPrice       : String?           = null

): Serializable