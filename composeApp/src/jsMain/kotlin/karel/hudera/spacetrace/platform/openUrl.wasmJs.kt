package karel.hudera.spacetrace.platform

import kotlinx.browser.window

internal actual fun openUrl(url: String?) {
    if (url != null) {
        window.open(url, "_blank")
    }
}