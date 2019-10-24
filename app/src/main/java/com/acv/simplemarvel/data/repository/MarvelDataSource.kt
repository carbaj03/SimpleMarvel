package com.acv.simplemarvel.data.repository

import com.acv.simplemarvel.domain.common.Return
import com.acv.simplemarvel.domain.entities.Hero

interface MarvelDataSource {
    suspend fun get(name: String): Return<Hero>
    suspend fun getAll(): Return<List<Hero>>

    fun populate(superHeroes: List<Hero>)
    fun isUpdated(): Boolean = true
    fun contains(key: String): Boolean = true
}