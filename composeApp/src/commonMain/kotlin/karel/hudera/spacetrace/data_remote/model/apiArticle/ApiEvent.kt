package karel.hudera.spacetrace.data_remote.model.apiArticle

import kotlinx.serialization.Serializable

@Serializable
data class ApiEvent(
    val event_id: Int,
    val provider: String
)