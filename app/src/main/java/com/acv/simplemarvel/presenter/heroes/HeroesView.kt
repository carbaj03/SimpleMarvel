package com.acv.simplemarvel.presenter.heroes

import com.acv.simplemarvel.presenter.model.HeroDto


interface HeroesView {
    fun show(heroes: List<HeroDto>)
    fun goToDetail(name: String)
}