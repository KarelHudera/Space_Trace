package karel.hudera.spacetrace.di.modules

import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val dispatchersModule = module {
    factory { Dispatchers.Default }
}