package karel.hudera.spacetrace.domain.interactors

import karel.hudera.spacetrace.domain.IRepository
import karel.hudera.spacetrace.domain.interactors.type.BaseUseCase
import karel.hudera.spacetrace.domain.model.Picture
import kotlinx.coroutines.CoroutineDispatcher

class GetPictureUseCase(
    private val repository: IRepository,
    dispatcher: CoroutineDispatcher,
) : BaseUseCase<Unit, Picture>(dispatcher){
    override suspend fun block(param: Unit): Picture = repository.getPicture()
}