package karel.hudera.spacetrace.platform

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.android.Android

actual class HttpClientEngineProvider {
    actual fun getEngine(): HttpClientEngine = Android.create()
}

actual fun getHttpClientEngineFactory(): HttpClientEngineProvider = HttpClientEngineProvider()