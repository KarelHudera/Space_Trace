package karel.hudera.spacetrace.data_remote.httpRequestBuilders

import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.parameter
import io.ktor.http.path
import io.ktor.http.takeFrom


fun HttpRequestBuilder.urlLaunchLibrary(path: String) {
    url {
        takeFrom(SPACE_DEVS_API_BASE_URL)
        path("2.3.0", path)
        parameter("format", "json")
    }
}