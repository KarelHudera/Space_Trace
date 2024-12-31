package karel.hudera.spacetrace.platform

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.js.Js

actual class HttpClientEngineProvider {
    actual fun getEngine(): HttpClientEngine = Js.create()
}

actual fun getHttpClientEngineFactory(): HttpClientEngineProvider = HttpClientEngineProvider()