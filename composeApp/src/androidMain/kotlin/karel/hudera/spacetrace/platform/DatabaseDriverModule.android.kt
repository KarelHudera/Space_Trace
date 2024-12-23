package karel.hudera.spacetrace.platform

import org.koin.core.module.Module
import org.koin.dsl.module

actual fun databaseDriverModule(): Module = module {
    single { DatabaseDriverFactory(get()) }
}
