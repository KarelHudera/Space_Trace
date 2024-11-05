package karel.hudera.spacetrace.di.modules

import karel.hudera.spacetrace.domain.interactors.GetPictureUseCase
import org.koin.dsl.module

val useCasesModule = module {
    factory { GetPictureUseCase(get(), get()) }
}