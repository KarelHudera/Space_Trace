package karel.hudera.spacetrace.presentation.ui.features.news

import karel.hudera.spacetrace.domain.model.Article
import karel.hudera.spacetrace.domain.model.Picture
import karel.hudera.spacetrace.presentation.model.ResourceUiState
import karel.hudera.spacetrace.presentation.mvi.UiEffect
import karel.hudera.spacetrace.presentation.mvi.UiEvent
import karel.hudera.spacetrace.presentation.mvi.UiState

interface NewsContract {
    sealed interface Event : UiEvent {
        data object OnTryCheckAgainClick : Event
        data object OnFavoritesClick : Event
        data class OnArticleClick(val articleId: Int) : Event
    }

    data class State(
        val picture: ResourceUiState<Picture>,
        val article: ResourceUiState<List<Article>>
    ) : UiState

    sealed interface Effect : UiEffect {
        data class NavigateToArticleDetail(val articleId: Int) : Effect
        data object NavigateToFavorites : Effect
    }
}