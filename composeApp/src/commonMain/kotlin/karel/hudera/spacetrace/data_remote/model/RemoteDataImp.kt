package karel.hudera.spacetrace.data_remote.model

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.header
import karel.hudera.spacetrace.data_remote.NASA_API_KEY
import karel.hudera.spacetrace.data_remote.NASA_END_POINT
import karel.hudera.spacetrace.data_remote.NASA_URL
import karel.hudera.spacetrace.data_remote.model.apiPicture.ApiPicture
import karel.hudera.spacetrace.data_remote.model.mapper.ApiPictureMapper
import karel.hudera.spacetrace.domain.model.Picture
import karel.hudera.spacetrace.repository.IRemoteData

class RemoteDataImp(
    private val httpClient: HttpClient,
    private val apiPictureMapper: ApiPictureMapper,
) : IRemoteData {
    override suspend fun getPictureFromApi(): Picture =
        apiPictureMapper.map(
            httpClient.get(NASA_URL + NASA_END_POINT) {
                header("X-Api-Key", NASA_API_KEY)
            }.body<ApiPicture>()
        )
}