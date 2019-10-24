package com.acv.simplemarvel.presenter.heroes.detail

import com.acv.simplemarvel.presenter.heroes.HeroDto


interface HeroeDetailView {
    fun show(heroe: HeroDto)
}