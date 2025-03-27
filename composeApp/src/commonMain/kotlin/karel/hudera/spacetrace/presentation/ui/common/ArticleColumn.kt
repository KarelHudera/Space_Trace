package karel.hudera.spacetrace.presentation.ui.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import karel.hudera.spacetrace.domain.model.Article

@Composable
fun ArticleColumn(
    characters: List<Article>,
    onArticleClick: (Long) -> Unit,
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top
    ) {
        items(
            items = characters,
            key = { it.id }
        ) { articles ->
            ArticleItem(
                article = articles,
                onClick = {
                    onArticleClick(articles.id)
                }
            )
        }
    }
}