package karel.hudera.spacetrace.domain

import karel.hudera.spacetrace.domain.model.Article
import karel.hudera.spacetrace.domain.model.Picture
import kotlinx.coroutines.flow.Flow

interface IRepository {
    suspend fun getPicture(): Picture
    suspend fun getArticles(): List<Article>
    suspend fun getArticle(articleId: Int): Article
    suspend fun getFavoriteArticles(): Flow<List<Article>>
    suspend fun addArticleToFavorites(article: Article)
    suspend fun removeArticleFromFavorites(articleId: Int)
    suspend fun isArticleFavorite(articleId: Int): Boolean
}