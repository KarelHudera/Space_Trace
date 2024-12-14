package karel.hudera.spacetrace.di.modules

import karel.hudera.spacetrace.presentation.ui.features.articleDetail.ArticleDetailViewModel
import karel.hudera.spacetrace.presentation.ui.features.news.NewsScreenViewModel
import org.koin.dsl.module

val viewModelModule = module {
    factory { NewsScreenViewModel(get(), get()) }
    factory { params -> ArticleDetailViewModel(get(), get(), get(), params.get()) }
}