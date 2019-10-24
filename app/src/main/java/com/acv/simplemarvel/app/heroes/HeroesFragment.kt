package com.acv.simplemarvel.app.heroes

import androidx.recyclerview.widget.LinearLayoutManager
import com.acv.simplemarvel.R
import com.acv.simplemarvel.app.common.*
import com.acv.simplemarvel.app.di.Injection
import com.acv.simplemarvel.app.main.NavigatorAc
import com.acv.simplemarvel.presenter.heroes.HeroesPresenter
import com.acv.simplemarvel.presenter.heroes.HeroesView
import com.acv.simplemarvel.presenter.heroes.HeroDto
import kotlinx.android.synthetic.main.fragment_heroes.*

class HeroesFragment : BaseFragment(), HeroesView, Injection, NavigatorAc {

    private val superHeroAdapter
            by lazy { SuperHeroAdapter(holder = ::HeroeViewHolder) { itemClick(it) } }

    private val presenter: HeroesPresenter by lazy { providePresenter(this) }

    override fun getLayout(): Int = R.layout.fragment_heroes

    override fun onCreate() {
        setupRecyclerView()
        presenter.init()
    }

    private fun setupRecyclerView() =
        with(rvMarvel) {
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(DividerDecorationK(context.color(R.color.colorPrimary), 1f))
            adapter = superHeroAdapter
        }

    override fun show(heroes: List<HeroDto>) {
        superHeroAdapter.add(heroes)
    }

    private fun itemClick(superHero: HeroDto) =
        presenter.onSuperHeroClicked(superHero)

    override fun goToDetail(name: String) {
        baseActivity.loadHeroeDetail(name)
    }
}