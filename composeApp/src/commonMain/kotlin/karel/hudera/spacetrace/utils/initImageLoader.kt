package karel.hudera.spacetrace.utils

import androidx.compose.runtime.Composable
import coil3.ImageLoader
import coil3.PlatformContext
import coil3.compose.setSingletonImageLoaderFactory
import coil3.disk.DiskCache
import coil3.memory.MemoryCache
import coil3.network.ktor3.KtorNetworkFetcherFactory
import coil3.request.CachePolicy
import coil3.request.crossfade
import coil3.util.DebugLogger
import okio.FileSystem

/**
 * Initializes a singleton [ImageLoader] instance for use throughout the app.
 * Sets caching policies based on the value of [disableDiskCache].
 *
 * @param disableDiskCache Boolean flag to enable or disable disk caching.
 */
@Composable
fun initImageLoader(disableDiskCache: Boolean) {
    setSingletonImageLoaderFactory { context ->
        if (disableDiskCache) context.asyncImageLoader() else
            context.asyncImageLoader().enableDiskCache()
    }
}


/**
 * Builds an asynchronous [ImageLoader] configured with caching and network fetcher components.
 *
 * @receiver [PlatformContext] Platform-specific context used for constructing the [ImageLoader].
 * @return Configured [ImageLoader] instance.
 */
fun PlatformContext.asyncImageLoader() =
    ImageLoader
        .Builder(this)
        .components { add(KtorNetworkFetcherFactory()) }
        .crossfade(true)
        .networkCachePolicy(CachePolicy.ENABLED)
        .diskCachePolicy(CachePolicy.ENABLED)
        .memoryCachePolicy(CachePolicy.ENABLED)
        .memoryCache {
            MemoryCache.Builder()
                .maxSizePercent(this, 0.25)
                .strongReferencesEnabled(true)
                .build()
        }
        .logger(DebugLogger())
        .build()

/**
 * Enables disk caching for the [ImageLoader] by adding a [DiskCache] component.
 *
 * @receiver [ImageLoader] The instance of [ImageLoader] for which disk cache is being enabled.
 * @return [ImageLoader] instance with disk cache configured.
 */
fun ImageLoader.enableDiskCache() = this.newBuilder()
    .diskCache {
        DiskCache.Builder()
            .directory(FileSystem.SYSTEM_TEMPORARY_DIRECTORY / "image_cache")
            .build()
    }.build()