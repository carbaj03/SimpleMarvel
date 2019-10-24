package com.acv.simplemarvel.presenter.heroes

import com.acv.simplemarvel.app.common.weak
import com.acv.simplemarvel.domain.usecase.GetHeroes
import com.acv.simplemarvel.presenter.model.HeroDto
import com.acv.simplemarvel.presenter.model.map
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class HeroesPresenter(
    view: HeroesView,
    private val getSuperHeroes: GetHeroes,
    override val coroutineContext: CoroutineContext
) : CoroutineScope {

    private val view: HeroesView? by weak(view)

    fun init() {
        launch {
            withContext(Dispatchers.IO) {
                getSuperHeroes().map { it.map { it.map() } }
            }.map { view?.show(it) }
        }
    }

    fun onSuperHeroClicked(superHero: HeroDto): Unit {
        view?.goToDetail(superHero.name)
    }
}