package karel.hudera.spacetrace

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import coil3.ImageLoader
import coil3.compose.setSingletonImageLoaderFactory
import coil3.request.crossfade
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import karel.hudera.spacetrace.presentation.ViewHolder
import karel.hudera.spacetrace.presentation.theme.AppTheme
import karel.hudera.spacetrace.utils.PlatformInfo

@Composable
internal fun App() {
    // Initialize Napier for logging with DebugAntilog
    LaunchedEffect(Unit) {
        Napier.base(DebugAntilog())
        val platformName = PlatformInfo().getPlatformName()
        Napier.i("\uD83D\uDFE2 App started on platform: $platformName")
    }

    // Set up image loader with crossfade effect
    setSingletonImageLoaderFactory { context ->
        ImageLoader.Builder(context)
            .crossfade(true)
            .build()
    }

    // Apply app theme and load main content view
    AppTheme {
        ViewHolder()
    }
}