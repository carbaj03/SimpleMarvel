package com.acv.simplemarvel.app.common

import android.os.Bundle

data class SavedInstance(val bundle: Bundle) {
    companion object {
        operator fun invoke(bundle: Bundle?): SavedInstance =
            bundle?.let { SavedInstance(bundle) } ?: SavedInstance(Bundle())
    }
}