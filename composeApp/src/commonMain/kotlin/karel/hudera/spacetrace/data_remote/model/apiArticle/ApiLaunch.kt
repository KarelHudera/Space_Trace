package karel.hudera.spacetrace.data_remote.model.apiArticle

import kotlinx.serialization.Serializable

@Serializable
data class ApiLaunch(
    val launch_id: String,
    val provider: String
)