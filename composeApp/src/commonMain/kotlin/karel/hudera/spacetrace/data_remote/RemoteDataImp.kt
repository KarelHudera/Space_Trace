package karel.hudera.spacetrace.data_remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import karel.hudera.spacetrace.data_remote.httpRequestBuilders.NASA_APOD
import karel.hudera.spacetrace.data_remote.model.apiArticle.ApiArticle
import karel.hudera.spacetrace.data_remote.model.apiArticle.ApiArticleResult
import karel.hudera.spacetrace.data_remote.model.apiPicture.ApiPicture
import karel.hudera.spacetrace.data_remote.httpRequestBuilders.urlNASA
import karel.hudera.spacetrace.data_remote.httpRequestBuilders.urlSpaceflightNews
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
            httpClient.get {
                urlNASA(NASA_APOD)
            }.body<ApiPicture>()
        )

    override suspend fun getArticlesFromApi(): List<Article> =
        apiArticleMapper.map(
            httpClient.get {
                urlSpaceflightNews("articles/")
            }.body<ApiArticle>().apiArticleResults
        )

    override suspend fun getArticleFromApi(articleId: String): Article =
        apiArticleMapper.map(
            httpClient.get {
                urlSpaceflightNews("articles/${articleId}")
            }.body<ApiArticleResult>()
        )
}