package co.ghostnotes.sample.compose.navigation

import android.app.Application
import timber.log.Timber

class ComposeNavigationApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}