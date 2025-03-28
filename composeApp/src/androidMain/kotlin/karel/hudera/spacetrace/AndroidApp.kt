package karel.hudera.spacetrace

import android.app.Application
import android.content.Context
import android.content.pm.ApplicationInfo
import karel.hudera.spacetrace.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level

class AndroidApp : Application() {
    companion object {
        lateinit var appContext: AndroidApp
    }

    override fun onCreate() {
        super.onCreate()

        appContext = this

        initKoin {
            androidLogger(if (isDebug()) Level.ERROR else Level.NONE)
            androidContext(this@AndroidApp)
        }
    }

    private fun Context.isDebug() = 0 != applicationInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE
}