package karel.hudera.spacetrace.di.modules

import karel.hudera.spacetrace.presentation.ui.screens.articleDetail.ArticleDetailViewModel
import karel.hudera.spacetrace.presentation.ui.screens.favouriteArticles.FavouriteArticlesViewModel
import karel.hudera.spacetrace.presentation.ui.screens.launches.LaunchesViewModel
import karel.hudera.spacetrace.presentation.ui.screens.news.NewsViewModel
import org.koin.dsl.module

val viewModelModule = module {
    factory { NewsViewModel(get(), get()) }
    factory { params -> ArticleDetailViewModel(get(), get(), get(), params.get()) }
    factory { FavouriteArticlesViewModel(get()) }
    factory { LaunchesViewModel(get()) }
}