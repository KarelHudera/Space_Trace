package karel.hudera.spacetrace.presentation.ui.screens.articleDetail

import karel.hudera.spacetrace.domain.model.Article
import karel.hudera.spacetrace.presentation.model.ResourceUiState
import karel.hudera.spacetrace.presentation.mvi.UiEffect
import karel.hudera.spacetrace.presentation.mvi.UiEvent
import karel.hudera.spacetrace.presentation.mvi.UiState

interface ArticleDetailContract {
    sealed interface Event : UiEvent {
        data object OnFavoriteClick : Event
        data object OnTryCheckAgainClick : Event
        data object OnBackPressed : Event
    }

    data class State(
        val article: ResourceUiState<Article>,
        val isFavorite: ResourceUiState<Boolean>,
    ) : UiState

    sealed interface Effect : UiEffect {
        data object ArticleAdded : Effect
        data object ArticleRemoved : Effect
        data object BackNavigation : Effect
    }
}