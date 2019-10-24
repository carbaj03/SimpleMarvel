package com.acv.simplemarvel.data.network.client


import com.acv.simplemarvel.data.network.dto.ApiMarvelResponse
import retrofit2.Call
import retrofit2.http.GET


interface MarvelClient {
    @GET("/bins/bvyob")
    suspend fun getMarvel(): ApiMarvelResponse
}