package karel.hudera.spacetrace

import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import karel.hudera.spacetrace.di.initKoin
import kotlinx.browser.document
import org.jetbrains.skiko.wasm.onWasmReady

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    initKoin {}

    onWasmReady {
        ComposeViewport(document.body!!) {
            CompositionLocalProvider{
                App(disableDiskCache = true)
            }
        }
    }
}

//fun main() {
//    initKoin {}
//    onWasmReady {
//        BrowserViewportWindow("Rick N Morty KMM") {
//            App()
//        }
//    }
//}
