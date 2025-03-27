package karel.hudera.spacetrace

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import karel.hudera.spacetrace.di.initKoin
import kotlinx.browser.document
import org.jetbrains.skiko.wasm.onWasmReady

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    initKoin {}

    onWasmReady {
        val body = document.body ?: return@onWasmReady
        ComposeViewport(body) {
            App(disableDiskCache = true)
        }
    }
}