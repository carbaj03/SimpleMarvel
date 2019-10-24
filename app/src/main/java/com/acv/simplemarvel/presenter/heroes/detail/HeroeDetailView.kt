package com.acv.simplemarvel.presenter.heroes.detail

import com.acv.simplemarvel.presenter.model.HeroDto


interface HeroeDetailView {
    fun show(heroe: HeroDto)
}