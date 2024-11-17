package karel.hudera.spacetrace.platform

class WasmPlatform: Platform {
    override val name: String = "Web with Kotlin/JS"
}

actual fun getPlatform(): Platform = WasmPlatform()