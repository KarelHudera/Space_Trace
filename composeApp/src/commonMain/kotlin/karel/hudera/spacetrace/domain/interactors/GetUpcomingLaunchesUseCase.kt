package karel.hudera.spacetrace.domain.interactors

import karel.hudera.spacetrace.domain.IRepository
import karel.hudera.spacetrace.domain.interactors.type.BaseUseCase
import karel.hudera.spacetrace.domain.model.Launch
import kotlinx.coroutines.CoroutineDispatcher

class GetUpcomingLaunchesUseCase(
    private val repository: IRepository,
    dispatcher: CoroutineDispatcher
) : BaseUseCase<Unit, List<Launch>>(dispatcher) {
    override suspend fun block(param: Unit): List<Launch> = repository.getUpcomingLaunches()
}

