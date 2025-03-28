package karel.hudera.spacetrace.di.modules

import karel.hudera.spacetrace.data_cache.CacheDataImp
import karel.hudera.spacetrace.data_remote.RemoteDataImp
import karel.hudera.spacetrace.domain.IRepository
import karel.hudera.spacetrace.repository.ICacheData
import karel.hudera.spacetrace.repository.IRemoteData
import karel.hudera.spacetrace.repository.RepositoryImp
import org.koin.dsl.module

val repositoryModule = module {
    single<ICacheData> { CacheDataImp(get()) }
    single<IRemoteData> { RemoteDataImp(get(), get(), get(), get()) }
    single<IRepository> { RepositoryImp(get(), get()) }
}