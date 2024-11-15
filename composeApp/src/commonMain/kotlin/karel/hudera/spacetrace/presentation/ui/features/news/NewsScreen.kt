package karel.hudera.spacetrace.presentation.ui.features.news

import androidx.compose.foundation.layout.fillMaxSize
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
import karel.hudera.spacetrace.presentation.ui.common.ActionAppBar
import karel.hudera.spacetrace.presentation.ui.common.ImageCard
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

        LaunchedEffect(key1 = Unit) {
            viewModel.effect.collectLatest { effect ->
                when (effect) {
                    else -> {}
                }
            }
        }

        Scaffold(
            topBar = { ActionAppBar() }
        ) {
            ResourceUiStateManager(
                modifier = Modifier.fillMaxSize(),
                resourceUiState = state.picture,
                successView = {
                    ImageCard(it)
                },
                onCheckAgain = { viewModel.setEvent(NewsScreenContract.Event.OnTryCheckAgainClick) },
                onTryAgain = { viewModel.setEvent(NewsScreenContract.Event.OnTryCheckAgainClick) }
            )
        }
    }
}