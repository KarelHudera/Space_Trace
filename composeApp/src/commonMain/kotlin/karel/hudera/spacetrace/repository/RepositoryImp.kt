package karel.hudera.spacetrace.repository

import karel.hudera.spacetrace.domain.IRepository
import karel.hudera.spacetrace.domain.model.Article
import karel.hudera.spacetrace.domain.model.Picture
import kotlinx.coroutines.flow.Flow

class RepositoryImp(
    private val cacheData: ICacheData,
    private val remoteData: IRemoteData,
) : IRepository {
    override suspend fun getPicture(): Picture =
        remoteData.getPictureFromApi()

    override suspend fun getArticles(): List<Article> =
        remoteData.getArticlesFromApi()

    override suspend fun getArticle(articleId: Long): Article =
        remoteData.getArticleFromApi(articleId)

    override suspend fun getFavoriteArticles(): Flow<List<Article>> =
        cacheData.getAllFavoriteArticles()

    override suspend fun addArticleToFavorites(article: Article) =
        cacheData.addArticleToFavorite(article)

    override suspend fun removeArticleFromFavorites(articleId: Long)  =
        cacheData.removeArticleFromFavorite(articleId)

    override suspend fun isArticleFavorite(articleId: Long): Boolean =
        cacheData.isArticleFavorite(articleId)
}