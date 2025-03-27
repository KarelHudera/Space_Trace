package karel.hudera.spacetrace.presentation.ui.screens.launches

import cafe.adriel.voyager.core.model.screenModelScope
import io.github.aakira.napier.Napier
import karel.hudera.spacetrace.domain.interactors.GetUpcomingLaunchesUseCase
import karel.hudera.spacetrace.presentation.model.ResourceUiState
import karel.hudera.spacetrace.presentation.mvi.BaseViewModel
import kotlinx.coroutines.launch

class LaunchesViewModel(
    private val getUpcomingLaunchesUseCase: GetUpcomingLaunchesUseCase,
) : BaseViewModel<LaunchesContract.Event, LaunchesContract.State, LaunchesContract.Effect>() {

    init {
        Napier.i("\uD83D\uDFE2 LaunchesViewModel initialized")
        getLaunches()
    }

    override fun createInitialState(): LaunchesContract.State =
        LaunchesContract.State(
            launch = ResourceUiState.Idle
        )

    override fun handleEvent(event: LaunchesContract.Event) {
        when (event) {
            is LaunchesContract.Event.OnLaunchClick -> TODO()
            LaunchesContract.Event.OnTryCheckAgainClick -> getLaunches()
        }
    }

    private fun getLaunches() {
        Napier.i("\uD83D\uDFE2 Fetching launches started")
        setState { copy(launch = ResourceUiState.Loading) }
        screenModelScope.launch {
            getUpcomingLaunchesUseCase(Unit)
                .onSuccess {
                    setState {
                        copy(
                            launch = if (it.isEmpty())
                                ResourceUiState.Empty.also {
                                    Napier.i("\uD83D\uDFE1 Launches data is empty")
                                }
                            else
                                ResourceUiState.Success(it).also {
                                    Napier.i("\uD83D\uDFE2 Launches data successfully loaded")
                                }
                        )
                    }
                }
                .onFailure { error ->
                    Napier.e("\uD83D\uDD34 Launches fetch failed: ${error.message}", error)
                    setState { copy(launch = ResourceUiState.Error()) }
                }
        }
    }
}