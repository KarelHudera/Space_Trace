package karel.hudera.spacetrace.repository

import karel.hudera.spacetrace.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface ICacheData {
    suspend fun addArticleToFavorite(article: Article)
    suspend fun removeArticleFromFavorite(articleId: Int)
    suspend fun getAllFavoriteArticles(): Flow<List<Article>>
    suspend fun isArticleFavorite(articleId: Int): Boolean
}