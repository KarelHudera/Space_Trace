package karel.hudera.spacetrace.di.modules

import io.github.aakira.napier.Napier
import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.cache.HttpCache
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.observer.ResponseObserver
import io.ktor.client.request.header
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.json
import karel.hudera.spacetrace.platform.getHttpClientEngineFactory
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val httpClientModule = module {
    val nativeEngine = getHttpClientEngineFactory().getEngine()

    single {
        HttpClient(nativeEngine) {

            install(ContentNegotiation) {
                json(
                    Json {
                        allowSpecialFloatingPointValues = true
                        ignoreUnknownKeys = true
                        prettyPrint = true
                        isLenient = true
                    }
                )
            }

            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        Napier.d(message, tag = "Napier")
                    }
                }
                level = LogLevel.ALL
            }

            install(HttpCache)

            install(ResponseObserver) {
                onResponse { response ->
                    if (!response.status.isSuccess()) {
                        Napier.e("Request failed with status: ${response.status.value}", tag = "Napier")
                    } else {
                        Napier.d("HTTP status: ${response.status.value}", tag = "Napier")
                    }
                }
            }

            install(DefaultRequest) {
                header(HttpHeaders.ContentType, ContentType.Application.Json)
            }
        }
    }
}