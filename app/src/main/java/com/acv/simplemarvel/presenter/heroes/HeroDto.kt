package com.acv.simplemarvel.presenter.heroes

import com.acv.simplemarvel.R
import com.acv.simplemarvel.app.common.ItemVisitable
import com.acv.simplemarvel.domain.entities.Hero

data class HeroDto(
        val name: String,
        val photo: String,
        val realName: String,
        val height: String,
        val power: String,
        val abilities: String,
        val groups: String
) : ItemVisitable {
    override fun type(): Int =
            R.layout.item_superhero
}

fun Hero.map(): HeroDto =
        HeroDto(name, photo, realName, height, power, abilities, groups)