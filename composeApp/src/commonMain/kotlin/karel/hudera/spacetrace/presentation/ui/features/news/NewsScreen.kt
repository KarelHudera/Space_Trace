package karel.hudera.spacetrace.presentation.ui.features.news

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import karel.hudera.spacetrace.presentation.ui.common.ActionAppBar
import karel.hudera.spacetrace.presentation.ui.common.ImageCard
import karel.hudera.spacetrace.presentation.ui.features.articleDetail.ArticleDetailScreen
import karel.hudera.spacetrace.presentation.ui.state.ResourceUiStateManager
import kotlinx.coroutines.flow.collectLatest
import org.koin.compose.koinInject

class NewsScreen() : Screen {
    override val key: ScreenKey = uniqueScreenKey

    @Composable
    override fun Content() {
        val viewModel = koinInject<NewsScreenViewModel>()

        val state by viewModel.uiState.collectAsState()

        val navigator = LocalNavigator.currentOrThrow

        val scrollState = rememberScrollState()


        LaunchedEffect(key1 = Unit) {
            viewModel.effect.collectLatest { effect ->
                when (effect) {
                    is NewsContract.Effect.NavigateToArticleDetail ->  navigator.push(ArticleDetailScreen())
                    NewsContract.Effect.NavigateToFavorites -> TODO()
                }
            }
        }

        Scaffold(
            topBar = { ActionAppBar() }
        ) {
            Column(Modifier.fillMaxSize()) {
                ResourceUiStateManager(
                    modifier = Modifier.fillMaxWidth().padding(top = 86.dp)
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
                    successView = {
                        LazyColumn {
                            items(
                                items = it,
                                key = { it.id }
                            ) {
                                Card(
                                    modifier = Modifier
                                        .padding(
                                            vertical = 8.dp,
                                            horizontal = 16.dp
                                        )
                                        .clickable { viewModel.setEvent(NewsContract.Event.OnArticleClick(it.id)) },
                                    elevation = CardDefaults.cardElevation(
                                        defaultElevation = 1.dp
                                    )
                                ) {
                                    Text(it.title, Modifier.padding(4.dp))
                                }
                            }
                        }
                    },
                    onCheckAgain = { viewModel.setEvent(NewsContract.Event.OnTryCheckAgainClick) },
                    onTryAgain = { viewModel.setEvent(NewsContract.Event.OnTryCheckAgainClick) }
                )
            }
        }
    }
}