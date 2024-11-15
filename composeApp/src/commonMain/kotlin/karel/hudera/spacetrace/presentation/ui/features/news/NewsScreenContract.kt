package karel.hudera.spacetrace.presentation.ui.features.news

import karel.hudera.spacetrace.domain.model.Picture
import karel.hudera.spacetrace.presentation.model.ResourceUiState
import karel.hudera.spacetrace.presentation.mvi.UiEffect
import karel.hudera.spacetrace.presentation.mvi.UiEvent
import karel.hudera.spacetrace.presentation.mvi.UiState

interface NewsScreenContract {
    sealed interface Event : UiEvent {
        data object OnTryCheckAgainClick : Event

    }

    data class State(
        val picture: ResourceUiState<Picture>
    ) : UiState

    sealed interface Effect : UiEffect {

    }
}