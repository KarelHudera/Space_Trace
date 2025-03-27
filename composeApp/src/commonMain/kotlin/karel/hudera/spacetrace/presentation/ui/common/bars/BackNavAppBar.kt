package karel.hudera.spacetrace.presentation.ui.common.bars

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import karel.hudera.spacetrace.presentation.ui.common.ActionBarIcon

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BackNavAppBar(
    title: String? = null,
    onBackPressed: () -> Unit,
    firstAction: () -> Unit = {},
    firstIcon: ImageVector? = null,
    secondAction: () -> Unit = {},
    secondIcon: ImageVector? = null
) {
    TopAppBar(
        title = {
            title?.let { Text(text = it) }
        },
        navigationIcon = { ArrowBackIcon(onBackPressed) },
        actions = {
            if (firstIcon != null) {
                ActionBarIcon(
                    onClick = firstAction,
                    icon = firstIcon
                )
            }

            if (secondIcon != null) {
                ActionBarIcon(
                    onClick = secondAction,
                    icon = secondIcon
                )
            }
        }
    )
}

@Composable
fun ArrowBackIcon(onBackPressed: () -> Unit) {
    IconButton(onClick = onBackPressed) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = null
        )
    }
}