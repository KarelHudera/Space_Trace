package karel.hudera.spacetrace.repository

import karel.hudera.spacetrace.domain.model.Article
import karel.hudera.spacetrace.domain.model.Picture


interface IRemoteData {
    suspend fun getPictureFromApi(): Picture
    suspend fun getArticlesFromApi(): List<Article>
    suspend fun getArticleFromApi(articleId: Int): Article
}