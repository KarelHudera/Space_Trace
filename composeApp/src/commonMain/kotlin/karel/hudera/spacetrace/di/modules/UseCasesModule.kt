package karel.hudera.spacetrace.di.modules

import karel.hudera.spacetrace.domain.interactors.GetArticleUseCase
import karel.hudera.spacetrace.domain.interactors.GetArticlesUseCase
import karel.hudera.spacetrace.domain.interactors.GetFavoriteArticlesUseCase
import karel.hudera.spacetrace.domain.interactors.GetPictureUseCase
import karel.hudera.spacetrace.domain.interactors.IsArticleFavoriteUseCase
import karel.hudera.spacetrace.domain.interactors.SwitchArticleFavoriteUseCase
import org.koin.dsl.module

val useCasesModule = module {
    factory { GetPictureUseCase(get(), get()) }
    factory { GetArticlesUseCase(get(), get()) }
    factory { GetArticleUseCase(get(), get()) }
    factory { IsArticleFavoriteUseCase(get(), get()) }
    factory { SwitchArticleFavoriteUseCase(get(), get()) }
    factory { GetFavoriteArticlesUseCase(get(), get()) }
}