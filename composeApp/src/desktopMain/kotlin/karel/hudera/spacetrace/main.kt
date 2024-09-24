package karel.hudera.spacetrace

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Space Trace",
    ) {
        App()
    }
}