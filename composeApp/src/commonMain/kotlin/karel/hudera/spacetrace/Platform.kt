package karel.hudera.spacetrace

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform