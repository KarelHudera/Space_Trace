package karel.hudera.spacetrace.repository

import karel.hudera.spacetrace.domain.IRepository
import karel.hudera.spacetrace.domain.model.Article
import karel.hudera.spacetrace.domain.model.Picture
import kotlinx.coroutines.flow.Flow

class RepositoryImp(
    private val remoteData: IRemoteData,
) : IRepository {
    override suspend fun getPicture(): Picture =
        remoteData.getPictureFromApi()

    override suspend fun getArticles(): List<Article> =
        remoteData.getArticlesFromApi()

    override suspend fun getArticle(articleId: Int): Article =
        remoteData.getArticleFromApi(articleId)

    override suspend fun getFavoriteArticles(): Flow<List<Article>> {
        TODO("Not yet implemented")
    }

    override suspend fun addArticleToFavorites(article: Article) {
        TODO("Not yet implemented")
    }

    override suspend fun removeArticleFromFavorites(articleId: Int) {
        TODO("Not yet implemented")
    }

    override suspend fun isArticleFavorite(articleId: Int): Boolean {
        TODO("Not yet implemented")
    }
}