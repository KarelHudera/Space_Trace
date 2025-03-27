package karel.hudera.spacetrace.domain.interactors

import karel.hudera.spacetrace.domain.IRepository
import karel.hudera.spacetrace.domain.interactors.type.BaseUseCase
import karel.hudera.spacetrace.domain.model.Article
import kotlinx.coroutines.CoroutineDispatcher

class GetArticlesUseCase(
    private val repository: IRepository,
    dispatcher: CoroutineDispatcher,
) : BaseUseCase<Unit, List<Article>>(dispatcher){
    override suspend fun block(param: Unit): List<Article> = repository.getArticles()
}