package karel.hudera.spacetrace

import androidx.compose.runtime.Composable
import karel.hudera.spacetrace.platform.initPermissionController
import karel.hudera.spacetrace.presentation.ui.navigation.ViewHolder
import karel.hudera.spacetrace.presentation.ui.theme.AppTheme
import karel.hudera.spacetrace.utils.initImageLoader
import karel.hudera.spacetrace.utils.initLogger
import org.koin.compose.KoinContext

/**
 * The main entry point for the SpaceTrace application.
 *
 * This Composable function initializes the necessary application-wide
 * dependencies such as logging and image loading, and then sets up the
 * application's main view with theming and navigation.
 *
 * @param disableDiskCache Optional flag to disable disk caching for images.
 */
@Composable
internal fun App(disableDiskCache: Boolean = false) = KoinContext {

    // Initialize Napier for logging with DebugAntilog
    initLogger()

    // Configure and initialize the global Coil ImageLoader instance
    initImageLoader(disableDiskCache)

    // for notifications
    initPermissionController().RequestUserPermissions()

    // Apply app theme and load main content view
    AppTheme {
        ViewHolder()
    }
}