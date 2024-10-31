package karel.hudera.spacetrace.platform

import io.ktor.client.engine.HttpClientEngine

expect class HttpClientEngineProvider() {
    fun getEngine(): HttpClientEngine
}
expect fun getHttpClientEngineFactory(): HttpClientEngineProvider