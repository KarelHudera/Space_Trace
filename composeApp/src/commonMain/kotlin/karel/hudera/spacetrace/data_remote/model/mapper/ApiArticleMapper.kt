package karel.hudera.spacetrace.data_remote.model.mapper

import karel.hudera.spacetrace.data_remote.model.apiArticle.ApiArticleResult
import karel.hudera.spacetrace.domain.model.Article
import karel.hudera.spacetrace.domain.model.map.Mapper


class ApiArticleMapper : Mapper<ApiArticleResult, Article>() {
    override fun map(model: ApiArticleResult): Article = model.run {
        Article(
            apiEvents,
            featured,
            id,
            imageUrl,
            apiLaunches,
            newsSite,
            publishedAt,
            summary,
            title,
            updatedAt,
            url
        )
    }

    override fun inverseMap(model: Article): ApiArticleResult {
        TODO("Not yet implemented")
    }
}