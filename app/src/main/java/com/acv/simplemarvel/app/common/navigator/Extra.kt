package com.acv.simplemarvel.app.common.navigator

import com.acv.simplemarvel.app.common.BaseActivity
import com.acv.simplemarvel.app.common.BaseFragment
import java.io.Serializable

interface ExtraExtensions {
    companion object {
        const val EXTRA = "EXTRA"
    }

    private fun <A> BaseFragment.getExtra(): Extra<A> =
        arguments?.getSerializable(EXTRA)!! as Extra<A>

    private fun <A> BaseActivity.getExtra(): Extra<A> =
        intent?.getSerializableExtra(EXTRA)!! as Extra<A>

    private fun <A> Extra<A>.extract(default: () -> A): A =
        fold(default, { it })

    fun <A> BaseFragment.extra(default: () -> A): Lazy<A> =
        lazy { (getExtra<A>().extract(default)) }

    fun <A> BaseActivity.extra(default: () -> A): Lazy<A> =
        lazy { (getExtra<A>().extract(default)) }

}

sealed class Extra<out A> : Serializable {
    companion object {
        operator fun <A> invoke(a: A) = Some(a)
    }

    inline fun <R> fold(ifEmpty: () -> R, ifSome: (A) -> R): R = when (this) {
        is None -> ifEmpty()
        is Some<A> -> ifSome(t)
    }

    inline fun <B> map(crossinline f: (A) -> B): Extra<B> =
        fold({ None }, { a -> Some(f(a)) })

    data class Some<T>(val t: T) : Extra<T>()
    object None : Extra<Nothing>()
}
