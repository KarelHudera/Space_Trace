package karel.hudera.spacetrace

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import karel.hudera.spacetrace.di.initKoin
import kotlinx.browser.document

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    initKoin {}

    val body = document.body ?: return
    ComposeViewport(body) {
        App(disableDiskCache = true)
    }
}