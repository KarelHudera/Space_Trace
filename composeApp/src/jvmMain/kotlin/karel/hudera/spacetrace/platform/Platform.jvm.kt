package karel.hudera.spacetrace.platform

class JVMPlatform : Platform {
    override val name: String = "${detectPlatform()}, Java ${System.getProperty("java.version")}"
}

fun detectPlatform(): String {
    val hostOs = System.getProperty("os.name")
    return when {
        hostOs.startsWith("Windows") -> "Windows"
        hostOs.startsWith("Mac") -> "Mac"
        hostOs.startsWith("Linux") -> "Linux"
        else -> "Unknown"
    }
}

actual fun getPlatform(): Platform = JVMPlatform()