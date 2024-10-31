package karel.hudera.spacetrace.utils

import karel.hudera.spacetrace.platform.getPlatform

class PlatformInfo {
    private val platform = getPlatform()

    fun getPlatformName(): String {
        return platform.name
    }
}