package karel.hudera.spacetrace.di

import androidx.compose.runtime.Composable
import karel.hudera.spacetrace.presentation.mvi.BaseViewModel
import karel.hudera.spacetrace.presentation.mvi.UiEffect
import karel.hudera.spacetrace.presentation.mvi.UiEvent
import karel.hudera.spacetrace.presentation.mvi.UiState
import org.koin.compose.currentKoinScope

@Composable
inline fun <reified VM : BaseViewModel<Event, State, Effect>, Event : UiEvent, State : UiState, Effect : UiEffect> koinViewModel(): VM {
    val scope = currentKoinScope()
    return scope.get<VM>()
}
