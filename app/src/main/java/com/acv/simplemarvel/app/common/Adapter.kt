package com.acv.simplemarvel.app.common

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.acv.simplemarvel.app.heroes.HeroeViewHolder
import com.acv.simplemarvel.presenter.heroes.HeroDto

typealias SuperHeroAdapter = Adapter<HeroeViewHolder, HeroDto>

abstract class ViewHolder<in M>(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun M.bind()
}

open class Adapter<VH : ViewHolder<M>, in M : ItemVisitable>(
        private var items: MutableList<M> = mutableListOf(),
        val holder: (view: View) -> VH,
        private val listener: (M) -> Unit
) : RecyclerView.Adapter<VH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            holder(parent.inflate(viewType))

    override fun onBindViewHolder(holder: VH, position: Int) = with(holder) {
        items[position].bind()
        itemView.setOnClickListener { listener(items[position]) }
    }

    override fun getItemViewType(position: Int) =
            items[position].type()

    override fun getItemCount() =
            items.size

    fun add(l: List<M>) = with(items) {
        clear()
        addAll(l)
        notifyDataSetChanged()
    }
}

