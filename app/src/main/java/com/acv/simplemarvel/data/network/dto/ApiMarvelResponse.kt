package com.acv.simplemarvel.data.network.dto

import com.google.gson.annotations.SerializedName

data class ApiMarvelResponse(
    @SerializedName("superheroes") var superheroes: List<MarvelResponse>
)