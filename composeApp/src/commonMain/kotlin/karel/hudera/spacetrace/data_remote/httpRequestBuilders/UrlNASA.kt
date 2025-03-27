package karel.hudera.spacetrace.data_remote.httpRequestBuilders

import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.parameter
import io.ktor.http.path
import io.ktor.http.takeFrom
import karel.hudera.spacetrace.data_remote.NASA_API_KEY

/**
 * Configures the HttpRequestBuilder for NASA API calls.
 *
 * @param path The specific endpoint path for the NASA API (e.g., "planetary/apod").
 */
fun HttpRequestBuilder.urlNASA(path: String) {
    url {
        takeFrom(NASA_API_BASE_URL)
        path(path)
        parameter("api_key", NASA_API_KEY)
    }
}