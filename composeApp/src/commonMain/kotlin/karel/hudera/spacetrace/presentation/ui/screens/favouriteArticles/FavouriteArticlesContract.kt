package karel.hudera.spacetrace.presentation.ui.screens.favouriteArticles

import karel.hudera.spacetrace.domain.model.Article
import karel.hudera.spacetrace.presentation.model.ResourceUiState
import karel.hudera.spacetrace.presentation.mvi.UiEffect
import karel.hudera.spacetrace.presentation.mvi.UiEvent
import karel.hudera.spacetrace.presentation.mvi.UiState

interface FavouriteArticlesContract {
    sealed interface Event : UiEvent {
        data object OnBackPressed : Event
        data object OnTryCheckAgainClick : Event
        data class OnArticleClick(val articleId: Long) : Event
    }

    data class State(
        val favoriteArticles: ResourceUiState<List<Article>>
    ) : UiState

    sealed interface Effect : UiEffect {
        data class NavigateToArticleDetail(val articleId: Long) : Effect
        data object BackNavigation : Effect
    }
}