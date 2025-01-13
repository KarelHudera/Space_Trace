package karel.hudera.spacetrace.data_remote.model.apiLaunch


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Orbit(
    @SerialName("abbrev")
    val abbrev: String,
    @SerialName("celestial_body")
    val celestialBody: CelestialBody,
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String
)