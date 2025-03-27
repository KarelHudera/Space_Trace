package karel.hudera.spacetrace.platform

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform