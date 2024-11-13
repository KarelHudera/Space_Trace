package karel.hudera.spacetrace.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier

/**
 * Initializes the [Napier] logging library with a debug logger for enhanced logging visibility.
 * Logs the platform information upon app startup.
 */
@Composable
fun initLogger() {
    LaunchedEffect(Unit) {
        Napier.base(DebugAntilog())
        val platformName = PlatformInfo().getPlatformName()
        Napier.i("\uD83D\uDFE2 App started on platform: $platformName")
        print("\uD83D\uDFE2 App started on platform: $platformName")
    }
}
