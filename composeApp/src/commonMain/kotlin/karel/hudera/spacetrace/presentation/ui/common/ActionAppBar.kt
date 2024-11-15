package karel.hudera.spacetrace.presentation.ui.common

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import compose.icons.EvaIcons
import compose.icons.evaicons.Fill
import compose.icons.evaicons.fill.Star

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ActionAppBar(
    onClick: () -> Unit = {},
) {
    TopAppBar(
        title = { Text(text = "News from space") },
        actions = {
            ActionBarIcon(
                onClick = onClick,
                icon = EvaIcons.Fill.Star
            )
        }
    )
}