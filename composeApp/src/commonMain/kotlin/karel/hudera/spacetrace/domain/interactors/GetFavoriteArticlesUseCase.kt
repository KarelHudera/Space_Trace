package karel.hudera.spacetrace.domain.interactors

import karel.hudera.spacetrace.domain.IRepository
import karel.hudera.spacetrace.domain.interactors.type.BaseUseCaseFlow
import karel.hudera.spacetrace.domain.model.Article
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow

class GetFavoriteArticlesUseCase(
    private val repository: IRepository,
    dispatcher: CoroutineDispatcher,
) : BaseUseCaseFlow<Unit, List<Article>>(dispatcher) {
    override suspend fun build(param: Unit): Flow<List<Article>> = repository.getFavoriteArticles()
}