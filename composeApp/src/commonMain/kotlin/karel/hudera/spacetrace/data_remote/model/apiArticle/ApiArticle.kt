package karel.hudera.spacetrace.data_remote.model.apiArticle


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiArticle(
    @SerialName("count")
    val count: Int,
    @SerialName("next")
    val next: String,
    @SerialName("previous")
    val previous: String?,
    @SerialName("results")
    val apiArticleResults: List<ApiArticleResult>
)