package karel.hudera.spacetrace.di.modules

import RLSViewModel
import org.koin.dsl.module

val viewModelModule = module {
    factory { RLSViewModel(get()) }
}