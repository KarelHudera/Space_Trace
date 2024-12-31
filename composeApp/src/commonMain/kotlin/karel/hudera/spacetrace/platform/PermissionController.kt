package karel.hudera.spacetrace.platform

import androidx.compose.runtime.Composable

expect class PermissionController {

    @Composable
    fun RequestUserPermissions()
}

expect fun initPermissionController(): PermissionController