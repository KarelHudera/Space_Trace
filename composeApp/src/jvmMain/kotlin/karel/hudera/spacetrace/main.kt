package karel.hudera.spacetrace

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowDecoration
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import karel.hudera.spacetrace.di.initKoin
import java.awt.Toolkit

@OptIn(ExperimentalComposeUiApi::class)
fun main() = application {
    initKoin {}

    val screenSize = Toolkit.getDefaultToolkit().screenSize

    Window(
        decoration = WindowDecoration.SystemDefault, // redundant
        state = rememberWindowState(
            width = screenSize.width.dp,
            height = screenSize.height.dp
        ),
        onCloseRequest = ::exitApplication,
        title = "Space Trace",
    ) {
        App()
    }
}

@Preview
@Composable
fun AppPreview() {
    App()
}