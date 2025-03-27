package karel.hudera.spacetrace.platform

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import io.github.aakira.napier.Napier

actual class PermissionController {

    @Composable
    actual fun RequestUserPermissions() {
        LaunchedEffect(Unit) {
            if (js("Notification.permission") == "granted") {
                Napier.i("\uD83D\uDFE2 Permission already granted.")

            } else {
                js("Notification.requestPermission()").then { result ->
                    if (result == "granted") {
                        Napier.i("\uD83D\uDFE2 Permission granted.")
                    } else {
                        Napier.e("\uD83D\uDFE2 Permission denied.")
                        // Optionally show guidance to enable notifications
                    }
                } as Unit
            }
        }
    }
}

actual fun initPermissionController(): PermissionController = PermissionController()