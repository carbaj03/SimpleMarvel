package com.acv.simplemarvel.domain.usecase

import com.acv.simplemarvel.data.repository.MarvelRepository
import com.acv.simplemarvel.domain.common.Return
import com.acv.simplemarvel.domain.entities.Hero

class GetHeroes(private val superHeroesRepository: MarvelRepository) {
    suspend operator fun invoke(): Return<List<Hero>> =
        superHeroesRepository.getAllSuperHeroes()
}