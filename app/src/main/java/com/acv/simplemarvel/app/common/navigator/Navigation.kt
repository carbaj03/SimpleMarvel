package com.acv.simplemarvel.app.common.navigator

import androidx.core.os.bundleOf
import com.acv.simplemarvel.app.common.BaseFragment

interface Navigation

inline fun <reified A : BaseFragment> Navigation.createFragment(args: Extra<*> = Extra.None): A =
    A::class.java.newInstance().apply { arguments = bundleOf(ExtraExtensions.EXTRA to args) }