package com.acv.simplemarvel.data.network.dto

import com.acv.simplemarvel.domain.entities.Hero
import com.google.gson.annotations.SerializedName

data class MarvelResponse(
        @SerializedName("name") val name: String,
        @SerializedName("photo") val photo: String,
        @SerializedName("realName") val realName: String,
        @SerializedName("height") val height: String,
        @SerializedName("power") val power: String,
        @SerializedName("abilities") val abilities: String,
        @SerializedName("groups") val groups: String
)

fun MarvelResponse.map(): Hero =
        Hero(name, photo, realName, height, power, abilities, groups)
