package karel.hudera.spacetrace.di.modules

import karel.hudera.spacetrace.data_cache.sqldelight.SharedDatabase
import org.koin.dsl.module

val databaseModule = module {
    single { SharedDatabase(get()) }
}