package karel.hudera.spacetrace.data_remote.model.apiArticle


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiArticleResult(
    @SerialName("events")
    val apiEvents: List<ApiEvent>,
    @SerialName("featured")
    val featured: Boolean,
    @SerialName("id")
    val id: Int,
    @SerialName("image_url")
    val imageUrl: String,
    @SerialName("launches")
    val apiLaunches: List<ApiLaunch>,
    @SerialName("news_site")
    val newsSite: String,
    @SerialName("published_at")
    val publishedAt: String,
    @SerialName("summary")
    val summary: String,
    @SerialName("title")
    val title: String,
    @SerialName("updated_at")
    val updatedAt: String,
    @SerialName("url")
    val url: String
)