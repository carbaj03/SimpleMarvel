package com.acv.simplemarvel.app.heroes.detail

import com.acv.simplemarvel.R
import com.acv.simplemarvel.app.common.BaseFragment
import com.acv.simplemarvel.app.common.navigator.WithExtra
import com.acv.simplemarvel.app.di.Injection
import com.acv.simplemarvel.presenter.model.HeroDto
import com.acv.simplemarvel.presenter.heroes.detail.HeroeDetailPresenter
import com.acv.simplemarvel.presenter.heroes.detail.HeroeDetailView
import kotlinx.android.synthetic.main.fragment_heroe.*

class HeroeDetailFragment : BaseFragment(), HeroeDetailView, Injection , WithExtra<String> {

    private val presenter: HeroeDetailPresenter by lazy { provideDetailPresenter(this) }

    override fun getLayout(): Int = R.layout.fragment_heroe

    override fun onCreate() {
        presenter.init(extra)
    }

    override val extra: String by extra { "" }

    override fun show(heroe: HeroDto) {
        tvName.text = heroe.name
    }
}