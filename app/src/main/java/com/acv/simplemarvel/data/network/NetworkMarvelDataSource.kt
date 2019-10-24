package com.acv.simplemarvel.data.network

import arrow.core.left
import arrow.core.right
import com.acv.simplemarvel.data.network.client.MarvelClient
import com.acv.simplemarvel.data.network.dto.map
import com.acv.simplemarvel.data.network.mapper.NetworkMapper
import com.acv.simplemarvel.data.repository.MarvelDataSource
import com.acv.simplemarvel.domain.common.Return
import com.acv.simplemarvel.domain.entities.Hero

class NetworkMarvelDataSource(
    private val apiClient: MarvelClient
) : NetworkMapper, MarvelDataSource {

    override fun populate(superHeroes: List<Hero>) {}

    override suspend fun getAll(): Return<List<Hero>> =
        try {
            apiClient.getMarvel().superheroes.map { it.map() }.right()
        } catch (exception: Exception) {
            exception.mapException().left()
        }

    override suspend fun get(name: String): Return<Hero> =
        try {
            apiClient.getMarvel().superheroes.map { it.map() }.first { it.name == name }.right()
        } catch (exception: Exception) {
            exception.mapException().left()
        }
}