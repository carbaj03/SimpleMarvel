package com.acv.simplemarvel.app.main

import com.acv.simplemarvel.R
import com.acv.simplemarvel.app.common.BaseActivity
import com.acv.simplemarvel.app.common.SavedInstance

class MainActivity : BaseActivity(), NavigatorAc {
    override val baseActivity: BaseActivity = this

    override fun create(savedInstance: SavedInstance) {
        loadHeroes()
    }

    override fun getLayout(): Int = R.layout.activity_main
}
