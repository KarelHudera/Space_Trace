package karel.hudera.spacetrace.domain

import karel.hudera.spacetrace.domain.model.Article
import karel.hudera.spacetrace.domain.model.Picture

interface IRepository {
    suspend fun getPicture(): Picture
    suspend fun getArticles(): List<Article>
    suspend fun getArticle(articleId: String): Article
}