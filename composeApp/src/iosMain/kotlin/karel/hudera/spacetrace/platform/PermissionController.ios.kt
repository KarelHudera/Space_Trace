package karel.hudera.spacetrace.platform

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import io.github.aakira.napier.Napier
import platform.UserNotifications.UNAuthorizationOptions
import platform.UserNotifications.UNUserNotificationCenter

actual class PermissionController {
    val options: UNAuthorizationOptions =
        (1uL shl 0) or (1uL shl 1) or (1uL shl 2) // .alert, .badge, .sound

    @Composable
    actual fun RequestUserPermissions() {
        LaunchedEffect(Unit) {
            UNUserNotificationCenter.currentNotificationCenter().requestAuthorizationWithOptions(
                options = options
            ) { granted, error ->
                if (granted) {
                    Napier.i("\uD83D\uDFE2 Permission granted.")
                } else {
                    error?.let {
                        Napier.e("Error: ${it.localizedDescription} $error")
                        // Show user guidance to enable notifications
                    }
                }
            }
        }
    }
}

actual fun initPermissionController(): PermissionController = PermissionController()