package karel.hudera.spacetrace.platform

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.darwin.Darwin

actual class HttpClientEngineProvider {
    actual fun getEngine(): HttpClientEngine = Darwin.create()
}

actual fun getHttpClientEngineFactory(): HttpClientEngineProvider = HttpClientEngineProvider()