package karel.hudera.spacetrace.presentation.ui.features.news

import cafe.adriel.voyager.core.model.screenModelScope
import io.github.aakira.napier.Napier
import karel.hudera.spacetrace.domain.interactors.GetArticlesUseCase
import karel.hudera.spacetrace.domain.interactors.GetPictureUseCase
import karel.hudera.spacetrace.presentation.model.ResourceUiState
import karel.hudera.spacetrace.presentation.mvi.BaseViewModel
import kotlinx.coroutines.launch

class NewsScreenViewModel(
    private val getPictureUseCase: GetPictureUseCase,
    private val getArticlesUseCase: GetArticlesUseCase
) : BaseViewModel<NewsContract.Event, NewsContract.State, NewsContract.Effect>() {

    init {
        Napier.i("\uD83D\uDFE2 NewsScreenViewModel initialized")
        getPicture()
        getArticles()
    }

    override fun createInitialState(): NewsContract.State =
        NewsContract.State(
            picture = ResourceUiState.Idle,
            article = ResourceUiState.Idle
        )

    override fun handleEvent(event: NewsContract.Event) {
        when (event) {
            NewsContract.Event.OnTryCheckAgainClick -> getPicture()
            is NewsContract.Event.OnArticleClick -> setEffect {
                NewsContract.Effect.NavigateToArticleDetail(
                    event.articleId
                )
            }

            NewsContract.Event.OnFavoritesClick -> TODO()
        }
    }

    private fun getPicture() {
        Napier.i("\uD83D\uDFE2 Fetching picture started")
        setState { copy(picture = ResourceUiState.Loading) }
        screenModelScope.launch {
            getPictureUseCase(Unit)
                .onSuccess {
                    setState {
                        copy(
                            picture = if (it.url.isEmpty())
                                ResourceUiState.Empty.also {
                                    Napier.i("\uD83D\uDFE1 Picture data is empty")
                                }
                            else
                                ResourceUiState.Success(it).also {
                                    Napier.i("\uD83D\uDFE2 Picture data successfully loaded")
                                }
                        )
                    }
                }
                .onFailure { error ->
                    Napier.e("\uD83D\uDD34 Picture fetch failed: ${error.message}", error)
                    setState { copy(picture = ResourceUiState.Error()) }
                }
        }
    }

    private fun getArticles() {
        Napier.i("\uD83D\uDFE2 Fetching articles started")
        setState { copy(article = ResourceUiState.Loading) }
        screenModelScope.launch {
            getArticlesUseCase(Unit)
                .onSuccess {
                    setState {
                        copy(
                            article = if (it.isEmpty())
                                ResourceUiState.Empty.also {
                                    Napier.i("\uD83D\uDFE1 Articles data is empty")
                                }
                            else
                                ResourceUiState.Success(it).also {
                                    Napier.i("\uD83D\uDFE2 Articles data successfully loaded")
                                }
                        )
                    }
                }
                .onFailure { error ->
                    Napier.e("\uD83D\uDD34 Articles fetch failed: ${error.message}", error)
                    setState { copy(article = ResourceUiState.Error()) }
                }
        }
    }
}