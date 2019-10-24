package com.acv.simplemarvel.presenter.heroes


interface HeroesView {
    fun show(heroes: List<HeroDto>)
    fun goToDetail(name: String)
}