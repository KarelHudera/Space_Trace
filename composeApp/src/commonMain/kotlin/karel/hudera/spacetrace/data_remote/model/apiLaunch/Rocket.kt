package karel.hudera.spacetrace.data_remote.model.apiLaunch


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Rocket(
    @SerialName("configuration")
    val configuration: Configuration,
    @SerialName("id")
    val id: Int
)