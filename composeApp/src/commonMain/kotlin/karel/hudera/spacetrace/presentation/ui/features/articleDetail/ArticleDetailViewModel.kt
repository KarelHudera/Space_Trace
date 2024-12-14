package karel.hudera.spacetrace.presentation.ui.features.articleDetail

import cafe.adriel.voyager.core.model.screenModelScope
import io.github.aakira.napier.Napier
import karel.hudera.spacetrace.domain.interactors.GetArticleUseCase
import karel.hudera.spacetrace.domain.interactors.IsArticleFavoriteUseCase
import karel.hudera.spacetrace.domain.interactors.SwitchArticleFavoriteUseCase
import karel.hudera.spacetrace.presentation.model.ResourceUiState
import karel.hudera.spacetrace.presentation.mvi.BaseViewModel
import kotlinx.coroutines.launch

class ArticleDetailViewModel(
    private val getArticleUseCase: GetArticleUseCase,
    private val isArticleFavoriteUseCase: IsArticleFavoriteUseCase,
    private val switchArticleFavoriteUseCase: SwitchArticleFavoriteUseCase,
    private val articleId: Int
) : BaseViewModel<ArticleDetailContract.Event, ArticleDetailContract.State, ArticleDetailContract.Effect>() {

    init {
        Napier.i("\uD83D\uDFE2 ArticleDetailViewModel initialized")
        getArticle(articleId)
        checkIfIsFavorite(articleId)
    }

    override fun createInitialState(): ArticleDetailContract.State =
        ArticleDetailContract.State(
            article = ResourceUiState.Idle,
            isFavorite = ResourceUiState.Idle
        )

    override fun handleEvent(event: ArticleDetailContract.Event) {
        when (event) {
            ArticleDetailContract.Event.OnBackPressed -> setEffect { ArticleDetailContract.Effect.BackNavigation }
            ArticleDetailContract.Event.OnFavoriteClick -> switchArticleFavorite(articleId)
            ArticleDetailContract.Event.OnTryCheckAgainClick -> getArticle(articleId)
        }
    }

    private fun getArticle(articleId: Int) {
        Napier.i("\uD83D\uDFE2 Fetching article started")
        setState { copy(article = ResourceUiState.Loading) }
        screenModelScope.launch {
            getArticleUseCase(articleId)
                .onSuccess {
                    setState {
                        copy(
                            article = if (it.title.isEmpty())
                                ResourceUiState.Empty.also {
                                    Napier.i("\uD83D\uDFE1 Article data is empty")
                                }
                            else
                                ResourceUiState.Success(it).also {
                                    Napier.i("\uD83D\uDFE2 Article data successfully loaded")
                                }
                        )
                    }
                }
                .onFailure { error ->
                    Napier.e("\uD83D\uDD34 Article fetch failed: ${error.message}", error)
                    setState { copy(article = ResourceUiState.Error()) }
                }
        }
    }

    private fun checkIfIsFavorite(articleId: Int) {
        setState { copy(isFavorite = ResourceUiState.Loading) }
        screenModelScope.launch {
            isArticleFavoriteUseCase(articleId)
                .onSuccess { setState { copy(isFavorite = ResourceUiState.Success(it)) } }
                .onFailure { setState { copy(isFavorite = ResourceUiState.Error()) } }
        }
    }

    private fun switchArticleFavorite(articleId: Int) {
        setState { copy(isFavorite = ResourceUiState.Loading) }
        screenModelScope.launch {
            switchArticleFavoriteUseCase(articleId)
                .onSuccess {
                    setState { copy(isFavorite = ResourceUiState.Success(it)) }
                    if (it) {
                        setEffect { ArticleDetailContract.Effect.ArticleAdded }
                    } else {
                        setEffect { ArticleDetailContract.Effect.ArticleRemoved }
                    }
                }.onFailure { setState { copy(isFavorite = ResourceUiState.Error()) } }
        }
    }
}