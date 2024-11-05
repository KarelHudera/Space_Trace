package karel.hudera.spacetrace.di.modules

import karel.hudera.spacetrace.data_remote.model.mapper.ApiPictureMapper
import org.koin.dsl.module

val mapperModule = module {
    factory { ApiPictureMapper() }
}