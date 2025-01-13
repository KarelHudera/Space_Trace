package karel.hudera.spacetrace.presentation.ui.screens.launches

import karel.hudera.spacetrace.domain.model.Launch
import karel.hudera.spacetrace.presentation.model.ResourceUiState
import karel.hudera.spacetrace.presentation.mvi.UiEffect
import karel.hudera.spacetrace.presentation.mvi.UiEvent
import karel.hudera.spacetrace.presentation.mvi.UiState

interface LaunchesContract {
    sealed interface Event : UiEvent {
        data object OnTryCheckAgainClick : Event
        data class OnLaunchClick(val launchId: Long) : Event
    }

    data class State(
        val launch: ResourceUiState<List<Launch>>
    ) : UiState

    sealed interface Effect : UiEffect {
        data class NavigateToLaunchDetail(val launchId: Long) : Effect
    }
}