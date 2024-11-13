package karel.hudera.spacetrace.platform

import java.awt.Desktop
import java.net.URI

internal actual fun openUrl(url: String?) {
    if (url != null) {
        try {
            Desktop.getDesktop().browse(URI(url))
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}