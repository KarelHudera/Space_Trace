package karel.hudera.spacetrace.domain.interactors

import karel.hudera.spacetrace.domain.IRepository
import karel.hudera.spacetrace.domain.interactors.type.BaseUseCase
import kotlinx.coroutines.CoroutineDispatcher

class SwitchArticleFavoriteUseCase(
    private val repository: IRepository,
    dispatcher: CoroutineDispatcher,
) : BaseUseCase<Int, Boolean>(dispatcher) {
    override suspend fun block(param: Int): Boolean {
        if (repository.isArticleFavorite(param)) {
            repository.removeArticleFromFavorites(param)
        } else {
            repository.addArticleToFavorites(repository.getArticle(param))
        }
        return repository.isArticleFavorite(param)
    }
}