package com.acv.simplemarvel.data.network.model

import com.google.gson.annotations.SerializedName

data class ApiMarvelResponse(
    @SerializedName("superheroes") var superheroes: List<MarvelResponse>
)