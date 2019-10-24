package com.acv.simplemarvel.app.heroes

import android.view.View
import com.acv.simplemarvel.app.common.ViewHolder
import com.acv.simplemarvel.presenter.model.HeroDto
import kotlinx.android.synthetic.main.item_superhero.view.*

class HeroeViewHolder(view: View) : ViewHolder<HeroDto>(view){

    override fun HeroDto.bind() = with(itemView){
        tvName.text = name
        tvRealName.text = realName
        tvHeight.text = this@bind.height
    }
}