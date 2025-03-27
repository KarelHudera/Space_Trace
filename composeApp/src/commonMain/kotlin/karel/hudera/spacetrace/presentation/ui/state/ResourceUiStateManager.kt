package karel.hudera.spacetrace.presentation.ui.state

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import karel.hudera.spacetrace.presentation.model.ResourceUiState

@Composable
fun <T> ResourceUiStateManager(
    modifier: Modifier = Modifier,
    resourceUiState: ResourceUiState<T>,
    successView: @Composable (data: T) -> Unit,
    loadingView: @Composable () -> Unit = { Loading() },
    onTryAgain: () -> Unit,
    msgTryAgain: String = "No data to show",
    onCheckAgain: () -> Unit,
    msgCheckAgain: String = "An error has occurred"
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        when (resourceUiState) {
            is ResourceUiState.Success -> successView(resourceUiState.data)

            is ResourceUiState.Error -> Error(
                modifier = modifier,
                onTryAgain = onTryAgain,
                msg = msgTryAgain
            )

            is ResourceUiState.Loading -> loadingView()

            is ResourceUiState.Empty -> Empty(
                modifier = modifier,
                onCheckAgain = onCheckAgain,
                msg = msgCheckAgain
            )

            is ResourceUiState.Idle -> Unit
        }
    }
}