package karel.hudera.spacetrace.presentation.ui.screens.articleDetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import coil3.compose.AsyncImage
import io.github.aakira.napier.Napier
import karel.hudera.spacetrace.di.koinViewModel
import karel.hudera.spacetrace.presentation.ui.common.bars.StateNavAppBar
import karel.hudera.spacetrace.presentation.ui.state.ResourceUiStateManager
import kotlinx.coroutines.flow.collectLatest

class ArticleDetailScreen(
    private val articleId: Long,
) : Screen {
    override val key: ScreenKey = uniqueScreenKey

    @Composable
    override fun Content() {
        val viewModel: ArticleDetailViewModel = koinViewModel(articleId)

        val state by viewModel.uiState.collectAsState()

        val navigator = LocalNavigator.currentOrThrow

        val snackbarHostState = remember { SnackbarHostState() }

        LaunchedEffect(key1 = Unit) {
            viewModel.effect.collectLatest { effect ->
                Napier.i("Collected effect: $effect")

                when (effect) {
                    ArticleDetailContract.Effect.ArticleAdded -> {
                        snackbarHostState.showSnackbar("Article added to favorites")
                        Napier.d("\uD83D\uDFE2 Rocket added to favorites")
                    }

                    ArticleDetailContract.Effect.ArticleRemoved -> {
                        snackbarHostState.showSnackbar("Article removed from favorites")
                        Napier.d("\uD83D\uDFE2 Rocket removed from favorites")
                    }

                    ArticleDetailContract.Effect.BackNavigation -> navigator.pop()
                }
            }
        }

        Scaffold(
            snackbarHost = {
                SnackbarHost(
                    hostState = snackbarHostState,
                    modifier = Modifier.padding(bottom = 82.dp)
                )
            },
            topBar = {
                StateNavAppBar(
                    onBackPressed = { viewModel.setEvent(ArticleDetailContract.Event.OnBackPressed) },
                    character = state.article,
                    favorite = state.isFavorite,
                    action = { viewModel.setEvent(ArticleDetailContract.Event.OnFavoriteClick) }
                )
            }
        ) { padding ->
            ResourceUiStateManager(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize(),
                resourceUiState = state.article,
                successView = { article ->
                    Column(Modifier.fillMaxSize().padding(horizontal = 16.dp)) {
                        AsyncImage(
                            modifier = Modifier.fillMaxWidth().clip(MaterialTheme.shapes.medium),
                            model = article.imageUrl,
                            contentDescription = article.title,
                            contentScale = ContentScale.FillWidth
                        )
                        Spacer(Modifier.height(8.dp))
                        Text(article.summary)
                    }
                },
                onTryAgain = { viewModel.setEvent(ArticleDetailContract.Event.OnTryCheckAgainClick) },
                onCheckAgain = { viewModel.setEvent(ArticleDetailContract.Event.OnTryCheckAgainClick) }
            )
        }
    }
}