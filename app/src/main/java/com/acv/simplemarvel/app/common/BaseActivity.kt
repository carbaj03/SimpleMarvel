package com.acv.simplemarvel.app.common

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.acv.simplemarvel.R

abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        create(SavedInstance(savedInstanceState))
    }

    abstract fun create(savedInstance: SavedInstance)
    abstract fun getLayout(): Int

    fun <T : BaseFragment> T.load(container: Int = R.id.fragment_container): Unit =
        supportFragmentManager
            .beginTransaction()
            .replace(container, this)
            .commitNow()
}


inline fun <reified M> BaseActivity.createIntent(f: Intent.() -> Unit = {}): Intent =
    Intent(this, M::class.java).apply { f() }