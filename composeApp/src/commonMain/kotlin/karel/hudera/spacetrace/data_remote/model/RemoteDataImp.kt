package karel.hudera.spacetrace.data_remote.model

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.parameter
import karel.hudera.spacetrace.data_remote.NASA_API_BASE_URL
import karel.hudera.spacetrace.data_remote.NASA_API_KEY
import karel.hudera.spacetrace.data_remote.NASA_APOD
import karel.hudera.spacetrace.data_remote.SPACEFLIGHT_ARTICLES
import karel.hudera.spacetrace.data_remote.SPACEFLIGHT_NEWS_API_BASE_URL
import karel.hudera.spacetrace.data_remote.model.apiArticle.ApiArticle
import karel.hudera.spacetrace.data_remote.model.apiArticle.ApiArticleResult
import karel.hudera.spacetrace.data_remote.model.apiPicture.ApiPicture
import karel.hudera.spacetrace.data_remote.model.mapper.ApiArticleMapper
import karel.hudera.spacetrace.data_remote.model.mapper.ApiPictureMapper
import karel.hudera.spacetrace.domain.model.Article
import karel.hudera.spacetrace.domain.model.Picture
import karel.hudera.spacetrace.repository.IRemoteData

class RemoteDataImp(
    private val httpClient: HttpClient,
    private val apiPictureMapper: ApiPictureMapper,
    private val apiArticleMapper: ApiArticleMapper
) : IRemoteData {
    override suspend fun getPictureFromApi(): Picture =
        apiPictureMapper.map(
            httpClient.get(NASA_API_BASE_URL + NASA_APOD) {
                header("X-Api-Key", NASA_API_KEY)
            }.body<ApiPicture>()
        )

    override suspend fun getArticlesFromApi(): List<Article> =
        apiArticleMapper.map(
            httpClient.get(SPACEFLIGHT_NEWS_API_BASE_URL + SPACEFLIGHT_ARTICLES) {
                parameter("format", "json")
            }.body<ApiArticle>().apiArticleResults
        )

    override suspend fun getArticleFromApi(articleId: String): Article =
        apiArticleMapper.map(
            httpClient.get(SPACEFLIGHT_NEWS_API_BASE_URL + SPACEFLIGHT_ARTICLES + articleId) {
                parameter("format", "json")
            }.body<ApiArticleResult>()
        )
}