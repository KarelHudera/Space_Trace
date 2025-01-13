package karel.hudera.spacetrace.data_remote.model.apiLaunch


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CelestialBody(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("response_mode")
    val responseMode: String
)