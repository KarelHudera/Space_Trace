package karel.hudera.spacetrace.di

import karel.hudera.spacetrace.di.modules.dispatchersModule
import karel.hudera.spacetrace.di.modules.httpClientModule
import karel.hudera.spacetrace.di.modules.mapperModule
import karel.hudera.spacetrace.di.modules.repositoryModule
import karel.hudera.spacetrace.di.modules.sqlDelightModule
import karel.hudera.spacetrace.di.modules.useCasesModule
import karel.hudera.spacetrace.di.modules.viewModelModule
import karel.hudera.spacetrace.platform.databaseDriverModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(appDeclaration: KoinAppDeclaration = {}) =
    startKoin {
        appDeclaration()
        modules(
            httpClientModule,
            repositoryModule,
            sqlDelightModule,
            dispatchersModule,
            useCasesModule,
            viewModelModule,
            mapperModule,
            databaseDriverModule()
        )
    }

fun initKoin() = initKoin {}