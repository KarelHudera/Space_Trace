package karel.hudera.spacetrace

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import karel.hudera.spacetrace.di.initKoin

fun main() = application {
    initKoin {}

    Window(
        onCloseRequest = ::exitApplication,
        title = "Space Trace",
    ) {
        App()
    }
}