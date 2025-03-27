package karel.hudera.spacetrace.data_cache

import app.cash.sqldelight.coroutines.asFlow
import karel.hudera.spacetrace.data_cache.database.SharedDatabase
import karel.hudera.spacetrace.domain.model.Article
import karel.hudera.spacetrace.repository.ICacheData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CacheDataImp(
    private val sharedDatabase: SharedDatabase
) : ICacheData {

    override suspend fun addArticleToFavorite(article: Article) {
        sharedDatabase {
            it.appDatabaseQueries.insertFavoriteArticle(
                article.id,
                article.imageUrl,
                article.newsSite,
                article.publishedAt,
                article.summary,
                article.title,
                article.updatedAt,
                article.url
            )
        }
    }

    override suspend fun removeArticleFromFavorite(articleId: Long) =
        sharedDatabase {
            it.appDatabaseQueries.removeFavoriteArticle(articleId)
        }

    override suspend fun getAllFavoriteArticles(): Flow<List<Article>> =
        sharedDatabase { articleDatabase ->
            articleDatabase.appDatabaseQueries.selectFavoriteArticles(::mapFavorite).asFlow()
                .map { it.executeAsList() }
        }

    override suspend fun isArticleFavorite(articleId: Long): Boolean =
        sharedDatabase {
            it.appDatabaseQueries.selectFavoriteArticleById(articleId).executeAsOne()
        }

    private fun mapFavorite(
        id: Long,
        imageUrl: String,
        newsSite: String,
        publishedAt: String,
        summary: String,
        title: String,
        updatedAt: String,
        url: String
    ): Article = Article(
        events = emptyList(),
        featured = false,
        id = id,
        imageUrl = imageUrl,
        launches = emptyList(),
        newsSite = newsSite,
        publishedAt = publishedAt,
        summary = summary,
        title = title,
        updatedAt = updatedAt,
        url = url,
    )
}