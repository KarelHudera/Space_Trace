package karel.hudera.spacetrace.presentation.ui.common

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun ActionBarIcon(
    enabled: Boolean = true,
    onClick: () -> Unit,
    icon: ImageVector
) {
    IconButton(
        onClick = onClick,
        enabled = enabled,
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null
        )
    }
}