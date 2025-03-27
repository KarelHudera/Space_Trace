package karel.hudera.spacetrace.data_remote.model.apiLaunch


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Pad(
    @SerialName("active")
    val active: Boolean,
    @SerialName("agencies")
    val agencies: List<AgencyX>,
    @SerialName("country")
    val country: Country,
    @SerialName("description")
    val description: String?,
    @SerialName("fastest_turnaround")
    val fastestTurnaround: String?,
    @SerialName("id")
    val id: Int,
    @SerialName("image")
    val image: ImageXXX?,
    @SerialName("info_url")
    val infoUrl: String?,
    @SerialName("latitude")
    val latitude: Double,
    @SerialName("location")
    val location: Location,
    @SerialName("longitude")
    val longitude: Double,
    @SerialName("map_image")
    val mapImage: String,
    @SerialName("map_url")
    val mapUrl: String?,
    @SerialName("name")
    val name: String,
    @SerialName("orbital_launch_attempt_count")
    val orbitalLaunchAttemptCount: Int,
    @SerialName("total_launch_count")
    val totalLaunchCount: Int,
    @SerialName("url")
    val url: String,
    @SerialName("wiki_url")
    val wikiUrl: String?
)