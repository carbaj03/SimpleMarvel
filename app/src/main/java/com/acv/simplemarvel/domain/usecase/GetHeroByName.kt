package com.acv.simplemarvel.domain.usecase

import com.acv.simplemarvel.data.repository.MarvelRepository
import com.acv.simplemarvel.domain.common.Return
import com.acv.simplemarvel.domain.entities.Hero

class GetHeroByName(private val repository: MarvelRepository) {

    suspend operator fun invoke(name: String): Return<Hero> =
        repository.getByName(name)
}