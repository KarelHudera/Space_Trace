package karel.hudera.spacetrace.platform

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.cio.CIO

actual class HttpClientEngineProvider {
    actual fun getEngine(): HttpClientEngine = CIO.create()
}
actual fun getHttpClientEngineFactory(): HttpClientEngineProvider = HttpClientEngineProvider()