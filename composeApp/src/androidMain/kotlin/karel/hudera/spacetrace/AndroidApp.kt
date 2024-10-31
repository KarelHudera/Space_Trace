package karel.hudera.spacetrace

import android.app.Application

class AndroidApp : Application() {
    companion object {
        lateinit var INSTANCE: AndroidApp
    }

    override fun onCreate() {
        super.onCreate()
//        initKoin {
//            androidLogger(if (isDebug()) Level.ERROR else Level.NONE)
//            androidContext(this@AndroidApp)
//        }
        INSTANCE = this
    }
}
