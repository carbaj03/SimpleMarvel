package com.acv.simplemarvel.app.main

import com.acv.simplemarvel.app.common.BaseActivity
import com.acv.simplemarvel.app.common.navigator.Extra
import com.acv.simplemarvel.app.common.navigator.Launcher
import com.acv.simplemarvel.app.common.navigator.Navigation
import com.acv.simplemarvel.app.common.navigator.createFragment
import com.acv.simplemarvel.app.heroes.HeroesFragment
import com.acv.simplemarvel.app.heroes.detail.HeroeDetailFragment

interface NavigatorAc : Launcher, Navigation {
    fun BaseActivity.loadHeroes(): Unit =
        createFragment<HeroesFragment>().load()

    fun BaseActivity.loadHeroeDetail(name: String): Unit =
        createFragment<HeroeDetailFragment>(Extra(name)).load()
}