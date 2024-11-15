package karel.hudera.spacetrace.domain.model

import androidx.compose.runtime.Immutable
import karel.hudera.spacetrace.data_remote.model.apiArticle.ApiEvent
import karel.hudera.spacetrace.data_remote.model.apiArticle.ApiLaunch

@Immutable
data class Article(
    val events: List<ApiEvent>,
    val featured: Boolean,
    val id: Int,
    val imageUrl: String,
    val launches: List<ApiLaunch>,
    val newsSite: String,
    val publishedAt: String,
    val summary: String,
    val title: String,
    val updatedAt: String,
    val url: String
)