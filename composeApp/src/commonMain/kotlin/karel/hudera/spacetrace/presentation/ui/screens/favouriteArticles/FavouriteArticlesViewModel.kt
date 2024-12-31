package karel.hudera.spacetrace.presentation.ui.screens.favouriteArticles

import cafe.adriel.voyager.core.model.screenModelScope
import karel.hudera.spacetrace.domain.interactors.GetFavoriteArticlesUseCase
import karel.hudera.spacetrace.presentation.model.ResourceUiState
import karel.hudera.spacetrace.presentation.mvi.BaseViewModel
import kotlinx.coroutines.launch

class FavouriteArticlesViewModel(
    private val getFavoriteArticlesUseCase: GetFavoriteArticlesUseCase
) : BaseViewModel<FavouriteArticlesContract.Event, FavouriteArticlesContract.State, FavouriteArticlesContract.Effect>() {

    init {
        getFavoriteArticles()
    }

    override fun createInitialState(): FavouriteArticlesContract.State =
        FavouriteArticlesContract.State(
            favoriteArticles = ResourceUiState.Idle
        )

    override fun handleEvent(event: FavouriteArticlesContract.Event) {
        when (event) {
            is FavouriteArticlesContract.Event.OnArticleClick -> setEffect {
                FavouriteArticlesContract.Effect.NavigateToArticleDetail(event.articleId)
            }

            FavouriteArticlesContract.Event.OnBackPressed -> setEffect { FavouriteArticlesContract.Effect.BackNavigation }
            FavouriteArticlesContract.Event.OnTryCheckAgainClick -> getFavoriteArticles()
        }
    }

    private fun getFavoriteArticles() {
        setState { copy(favoriteArticles = ResourceUiState.Loading) }
        screenModelScope.launch {
            getFavoriteArticlesUseCase(Unit).collect {
                it.onSuccess {
                    setState {
                        copy(
                            favoriteArticles =
                            if (it.isEmpty())
                                ResourceUiState.Empty
                            else
                                ResourceUiState.Success(it)
                        )
                    }
                }.onFailure { setState { copy(favoriteArticles = ResourceUiState.Error()) } }
            }
        }
    }
}