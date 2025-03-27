package karel.hudera.spacetrace.presentation.ui.common.bars

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import karel.hudera.spacetrace.presentation.ui.common.ActionBarIcon

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ActionAppBar(
    title: String,
    action: () -> Unit = {},
    icon: ImageVector? = null
) {
    TopAppBar(
        title = { Text(text = title) },
        actions = {
            if (icon != null) {
                ActionBarIcon(
                    onClick = action,
                    icon = icon
                )
            }
        }
    )
}