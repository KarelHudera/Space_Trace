package karel.hudera.spacetrace.presentation.ui.screens.news

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import karel.hudera.spacetrace.di.koinViewModel
import karel.hudera.spacetrace.presentation.ui.common.ArticleColumn
import karel.hudera.spacetrace.presentation.ui.common.ImageCard
import karel.hudera.spacetrace.presentation.ui.common.bars.ActionAppBar
import karel.hudera.spacetrace.presentation.ui.screens.articleDetail.ArticleDetailScreen
import karel.hudera.spacetrace.presentation.ui.screens.favouriteArticles.FavouriteArticlesScreen
import karel.hudera.spacetrace.presentation.ui.state.ResourceUiStateManager
import kotlinx.coroutines.flow.collectLatest

class NewsScreen : Screen {
    override val key: ScreenKey = uniqueScreenKey

    @Composable
    override fun Content() {
        val viewModel: NewsScreenViewModel = koinViewModel()

        val state by viewModel.uiState.collectAsState()

        val navigator = LocalNavigator.currentOrThrow

        LaunchedEffect(key1 = Unit) {
            viewModel.effect.collectLatest { effect ->
                when (effect) {
                    is NewsContract.Effect.NavigateToArticleDetail -> navigator.push(
                        ArticleDetailScreen(effect.articleId)
                    )

                    NewsContract.Effect.NavigateToFavorites ->
                        navigator.push(FavouriteArticlesScreen())
                }
            }
        }

        Scaffold(
            topBar = { ActionAppBar { viewModel.setEvent(NewsContract.Event.OnFavoritesClick) } }
        ) { padding ->
            Column(
                Modifier
                    .padding(padding)
                    .fillMaxSize()
            ) {
                ResourceUiStateManager(
                    modifier = Modifier.fillMaxWidth()
                        .heightIn(min = 0.dp, max = 300.dp),
                    resourceUiState = state.picture,
                    successView = {
                        ImageCard(it)
                    },
                    onCheckAgain = { viewModel.setEvent(NewsContract.Event.OnTryCheckAgainClick) },
                    onTryAgain = { viewModel.setEvent(NewsContract.Event.OnTryCheckAgainClick) }
                )
                ResourceUiStateManager(
                    modifier = Modifier.fillMaxWidth().heightIn(min = 0.dp, max = 900.dp),
                    resourceUiState = state.article,
                    successView = { articles ->
                        ArticleColumn(
                            characters = articles,
                            onArticleClick = { articleId ->
                                viewModel.setEvent(
                                    NewsContract.Event.OnArticleClick(
                                        articleId
                                    )
                                )
                            }
                        )
                    },
                    onCheckAgain = { viewModel.setEvent(NewsContract.Event.OnTryCheckAgainClick) },
                    onTryAgain = { viewModel.setEvent(NewsContract.Event.OnTryCheckAgainClick) }
                )
            }
        }
    }
}