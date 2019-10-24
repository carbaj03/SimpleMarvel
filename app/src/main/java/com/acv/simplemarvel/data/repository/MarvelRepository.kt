package com.acv.simplemarvel.data.repository

import com.acv.simplemarvel.domain.common.Return
import com.acv.simplemarvel.domain.entities.Hero


class MarvelRepository(
    private val datasources: List<MarvelDataSource>
) {

    suspend fun getAllSuperHeroes(): Return<List<Hero>> =
        datasources.first { it.isUpdated() }
            .getAll()
            .map { list ->
                datasources.forEach { it.populate(list) }
                list
            }

    suspend fun getByName(name : String): Return<Hero> =
        datasources.first { it.isUpdated() && it.contains(name) }.get(name)
}