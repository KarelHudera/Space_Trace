package karel.hudera.spacetrace.data_remote.model.apiLaunch


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Location(
    @SerialName("active")
    val active: Boolean,
    @SerialName("celestial_body")
    val celestialBody: CelestialBodyX,
    @SerialName("country")
    val country: Country,
    @SerialName("description")
    val description: String,
    @SerialName("id")
    val id: Int,
    @SerialName("image")
    val image: ImageXXX,
    @SerialName("latitude")
    val latitude: Double?,
    @SerialName("longitude")
    val longitude: Double?,
    @SerialName("map_image")
    val mapImage: String,
    @SerialName("name")
    val name: String,
    @SerialName("response_mode")
    val responseMode: String,
    @SerialName("timezone_name")
    val timezoneName: String,
    @SerialName("total_landing_count")
    val totalLandingCount: Int,
    @SerialName("total_launch_count")
    val totalLaunchCount: Int,
    @SerialName("url")
    val url: String
)