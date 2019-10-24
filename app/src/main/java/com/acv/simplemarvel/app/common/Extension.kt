package com.acv.simplemarvel.app.common

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat

infix fun ViewGroup.inflate(res: Int) =
        LayoutInflater.from(context).inflate(res, this, false)

fun View.gone() {
    this.visibility = View.GONE
}

fun View.show() {
    this.visibility = View.VISIBLE
}

fun Context.color(color: Int) =
        ContextCompat.getColor(this, color)
