package karel.hudera.spacetrace.presentation.ui.screens.favouriteArticles

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import karel.hudera.spacetrace.di.koinViewModel
import karel.hudera.spacetrace.presentation.ui.common.ArticleColumn
import karel.hudera.spacetrace.presentation.ui.common.bars.BackNavAppBar
import karel.hudera.spacetrace.presentation.ui.screens.articleDetail.ArticleDetailScreen
import karel.hudera.spacetrace.presentation.ui.state.ResourceUiStateManager
import kotlinx.coroutines.flow.collectLatest

class FavouriteArticlesScreen() : Screen {
    override val key: ScreenKey = uniqueScreenKey

    @Composable
    override fun Content() {
        val viewModel: FavouriteArticlesViewModel = koinViewModel()

        val state by viewModel.uiState.collectAsState()

        val navigator = LocalNavigator.currentOrThrow

        LaunchedEffect(key1 = Unit) {
            viewModel.effect.collectLatest { effect ->
                when (effect) {
                    FavouriteArticlesContract.Effect.BackNavigation -> navigator.pop()
                    is FavouriteArticlesContract.Effect.NavigateToArticleDetail -> navigator.push(
                        ArticleDetailScreen(effect.articleId)
                    )
                }
            }
        }

        Scaffold(
            topBar = {
                BackNavAppBar(
                    title = "Favorite articles",
                    onBackPressed = {
                        viewModel.setEvent(FavouriteArticlesContract.Event.OnBackPressed)
                    }
                )
            }

        ) { padding ->
            ResourceUiStateManager(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize(),
                resourceUiState = state.favoriteArticles,
                successView = { favorites ->
                    ArticleColumn(
                        characters = favorites,
                        onArticleClick = { articleId ->
                            viewModel.setEvent(
                                FavouriteArticlesContract.Event.OnArticleClick(
                                    articleId
                                )
                            )
                        }
                    )
                },
                onTryAgain = { viewModel.setEvent(FavouriteArticlesContract.Event.OnTryCheckAgainClick) },
                onCheckAgain = { viewModel.setEvent(FavouriteArticlesContract.Event.OnTryCheckAgainClick) },
                msgCheckAgain = "You don't have favorite articles yet"
            )
        }
    }
}

