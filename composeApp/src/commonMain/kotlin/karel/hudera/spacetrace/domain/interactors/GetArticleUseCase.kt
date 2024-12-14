package karel.hudera.spacetrace.domain.interactors

import karel.hudera.spacetrace.domain.IRepository
import karel.hudera.spacetrace.domain.interactors.type.BaseUseCase
import karel.hudera.spacetrace.domain.model.Article
import kotlinx.coroutines.CoroutineDispatcher

class GetArticleUseCase(
    private val repository: IRepository,
    dispatcher: CoroutineDispatcher,
) : BaseUseCase<Int, Article>(dispatcher){
    override suspend fun block(param: Int): Article = repository.getArticle(param)
}