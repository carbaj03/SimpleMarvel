package com.acv.simplemarvel.presenter.heroes.detail

import com.acv.simplemarvel.app.common.weak
import com.acv.simplemarvel.domain.usecase.GetHeroByName
import com.acv.simplemarvel.presenter.model.map
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class HeroeDetailPresenter(
    view: HeroeDetailView,
    private val getHeroByName: GetHeroByName,
    override val coroutineContext: CoroutineContext
) : CoroutineScope {

    private val view: HeroeDetailView? by weak(view)

    fun init(name : String) {
        launch {
            withContext(Dispatchers.IO) {
                getHeroByName(name).map { it.map() }
            }.map { view?.show(it) }
        }
    }

}