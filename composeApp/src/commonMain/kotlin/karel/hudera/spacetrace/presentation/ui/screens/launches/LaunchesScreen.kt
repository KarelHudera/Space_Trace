package karel.hudera.spacetrace.presentation.ui.screens.launches

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import coil3.compose.AsyncImage
import karel.hudera.spacetrace.di.koinViewModel
import karel.hudera.spacetrace.presentation.ui.common.bars.ActionAppBar
import karel.hudera.spacetrace.presentation.ui.state.ResourceUiStateManager
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlin.time.Duration.Companion.seconds

class LaunchesScreen : Screen {
    override val key: ScreenKey = uniqueScreenKey

    @Composable
    override fun Content() {
        val viewModel: LaunchesViewModel = koinViewModel()

        val state by viewModel.uiState.collectAsState()

        val navigator = LocalNavigator.currentOrThrow

        LaunchedEffect(key1 = Unit) {
            viewModel.effect.collectLatest { effect ->
                when (effect) {
                    is LaunchesContract.Effect.NavigateToLaunchDetail -> TODO()
                }
            }
        }

        Scaffold(
            topBar = {
                ActionAppBar(
                    title = "Upcoming launches"
                )
            }
        ) { padding ->
            Column(
                Modifier
                    .padding(padding)
                    .fillMaxSize()
            ) {
                ResourceUiStateManager(
                    modifier = Modifier.fillMaxSize(),
                    resourceUiState = state.launch,
                    successView = { launches ->
                        LazyColumn(
                            modifier = Modifier.fillMaxSize().padding(bottom = 80.dp),
                            verticalArrangement = Arrangement.Top
                        ) {
                            items(
                                items = launches,
                                key = { it.id }
                            ) { launch ->
                                Card(
                                    modifier = Modifier
                                        .padding(8.dp)
                                        .fillMaxWidth()
                                ) {
                                    Box {
                                        AsyncImage(
                                            model = launch.image,
                                            contentDescription = null,
                                            modifier = Modifier.fillMaxWidth().height(180.dp),
                                            contentScale = ContentScale.Crop
                                        )
                                        Text(
                                            launch.name,
                                            style = MaterialTheme.typography.bodyMedium,
                                            modifier = Modifier.padding(8.dp).graphicsLayer {
                                                 BlendMode.Difference
                                            }
                                        )
                                    }
                                    LaunchCountdown(launch.windowStart)
                                }
                            }
                        }
                    },
                    onCheckAgain = { viewModel.setEvent(LaunchesContract.Event.OnTryCheckAgainClick) },
                    onTryAgain = { viewModel.setEvent(LaunchesContract.Event.OnTryCheckAgainClick) }
                )
            }
        }
    }
}

@Composable
fun LaunchCountdown(launchTime: String) {
    val targetTime = Instant.parse(launchTime)

    var days by remember { mutableStateOf(0L) }
    var hours by remember { mutableStateOf(0L) }
    var minutes by remember { mutableStateOf(0L) }
    var seconds by remember { mutableStateOf(0L) }

    LaunchedEffect(Unit) {
        while (true) {
            val now = Clock.System.now()
            val duration = targetTime - now

            if (duration.isNegative()) {
                break
            }

            days = duration.inWholeDays
            hours = duration.inWholeHours % 24
            minutes = duration.inWholeMinutes % 60
            seconds = duration.inWholeSeconds % 60

            delay(1.seconds)
        }
    }

    CountdownRow(days, hours, minutes, seconds)
}

@Composable
fun CountdownRow(days: Long, hours: Long, minutes: Long, seconds: Long) {
    Row(
        Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center
    ) {
        AnimatedDigit(label = "Days", value = days)
        AnimatedDigit(label = "Hours", value = hours)
        AnimatedDigit(label = "Minutes", value = minutes)
        AnimatedDigit(label = "Seconds", value = seconds)
    }
}

@Composable
fun AnimatedDigit(label: String, value: Long) {
    Column(
        modifier = Modifier.padding(8.dp)
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall,
            textAlign = TextAlign.Center
        )

        AnimatedContent(
            contentAlignment = Alignment.Center,
            targetState = value,
            transitionSpec = {
                slideInVertically(initialOffsetY = { -it }) togetherWith slideOutVertically(
                    targetOffsetY = { it })
            }
        ) { animatedValue ->
            Text(
                text = animatedValue.toString().padStart(2, '0'),
                style = MaterialTheme.typography.headlineLarge,
                textAlign = TextAlign.Center
            )
        }
    }
}