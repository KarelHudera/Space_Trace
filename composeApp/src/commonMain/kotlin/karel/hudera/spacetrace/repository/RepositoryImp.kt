package karel.hudera.spacetrace.repository

import karel.hudera.spacetrace.domain.IRepository
import karel.hudera.spacetrace.domain.model.Article
import karel.hudera.spacetrace.domain.model.Picture

class RepositoryImp(
    private val remoteData: IRemoteData,
) : IRepository {
    override suspend fun getPicture(): Picture =
        remoteData.getPictureFromApi()

    override suspend fun getArticles(): List<Article> =
        remoteData.getArticlesFromApi()

    override suspend fun getArticle(articleId: String): Article =
        getArticle(articleId)
}