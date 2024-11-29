package karel.hudera.spacetrace.data_remote.httpRequestBuilders

import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.parameter
import io.ktor.http.path
import io.ktor.http.takeFrom

fun HttpRequestBuilder.urlSpaceflightNews(path: String) {
    url {
        takeFrom(SPACEFLIGHT_NEWS_API_BASE_URL)
        path("v4", path)
        parameter("format", "json")
    }
}