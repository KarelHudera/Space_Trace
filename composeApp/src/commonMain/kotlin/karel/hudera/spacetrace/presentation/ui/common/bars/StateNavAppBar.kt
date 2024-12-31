package karel.hudera.spacetrace.presentation.ui.common.bars

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextOverflow
import karel.hudera.spacetrace.domain.model.Article
import karel.hudera.spacetrace.presentation.model.ResourceUiState
import karel.hudera.spacetrace.presentation.ui.common.ActionBarIcon
import karel.hudera.spacetrace.presentation.ui.state.ResourceUiStateManager

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StateNavAppBar(
    character: ResourceUiState<Article>,
    favorite: ResourceUiState<Boolean>,
    onBackPressed: () -> Unit,
    action: () -> Unit
) {
    TopAppBar(
        title = {
            ResourceUiStateManager(
                resourceUiState = character,
                successView = {
                    Text(
                        text = it.title, maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                },
                loadingView = { Text(text = "....") },
                onCheckAgain = {},
                onTryAgain = {}
            )
        },
        navigationIcon = { ArrowBackIcon(onBackPressed) },
        actions = {
            ResourceUiStateManager(
                resourceUiState = favorite,
                successView = {
                    ActionBarIcon(
                        onClick = action,
                        icon = if (it) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder
                    )
                },
                loadingView = {
                    ActionBarIcon(
                        enabled = false,
                        onClick = {},
                        icon = Icons.Filled.Favorite
                    )
                },
                onCheckAgain = {},
                onTryAgain = {}
            )
        }
    )
}