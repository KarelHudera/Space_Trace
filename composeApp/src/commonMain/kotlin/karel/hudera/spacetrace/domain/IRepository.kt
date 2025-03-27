package karel.hudera.spacetrace.domain

import karel.hudera.spacetrace.domain.model.Article
import karel.hudera.spacetrace.domain.model.Launch
import karel.hudera.spacetrace.domain.model.Picture
import kotlinx.coroutines.flow.Flow

interface IRepository {
    suspend fun getPicture(): Picture
    suspend fun getArticles(): List<Article>
    suspend fun getArticle(articleId: Long): Article
    suspend fun getFavoriteArticles(): Flow<List<Article>>
    suspend fun isArticleFavorite(articleId: Long): Boolean
    suspend fun addArticleToFavorites(article: Article)
    suspend fun removeArticleFromFavorites(articleId: Long)
    suspend fun getUpcomingLaunches(): List<Launch>
}