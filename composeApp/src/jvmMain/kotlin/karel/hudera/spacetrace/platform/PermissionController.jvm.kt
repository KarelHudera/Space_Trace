package karel.hudera.spacetrace.platform

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import io.github.aakira.napier.Napier

actual class PermissionController {

    @Composable
    actual fun RequestUserPermissions() {
        LaunchedEffect(Unit) {
            Napier.i("\uD83D\uDFE2 Desktop does not require explicit notification permissions.")
        }
    }
}

actual fun initPermissionController(): PermissionController = PermissionController()