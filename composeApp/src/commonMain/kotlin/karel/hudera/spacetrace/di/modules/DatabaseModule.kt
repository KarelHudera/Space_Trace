package karel.hudera.spacetrace.di.modules

import karel.hudera.spacetrace.data_cache.database.SharedDatabase
import org.koin.dsl.module

val databaseModule = module {
    single { SharedDatabase(get()) }
}