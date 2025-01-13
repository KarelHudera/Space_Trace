package karel.hudera.spacetrace.data_remote.model.apiLaunch


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiLaunchResult(
    @SerialName("agency_launch_attempt_count")
    val agencyLaunchAttemptCount: Int,
    @SerialName("agency_launch_attempt_count_year")
    val agencyLaunchAttemptCountYear: Int,
    @SerialName("failreason")
    val failreason: String,
    @SerialName("hashtag")
    val hashtag: String?,
    @SerialName("id")
    val id: String,
    @SerialName("image")
    val image: Image,
    @SerialName("infographic")
    val infographic: String?,
    @SerialName("last_updated")
    val lastUpdated: String,
    @SerialName("launch_designator")
    val launchDesignator: String?,
    @SerialName("launch_service_provider")
    val launchServiceProvider: LaunchServiceProvider,
    @SerialName("location_launch_attempt_count")
    val locationLaunchAttemptCount: Int,
    @SerialName("location_launch_attempt_count_year")
    val locationLaunchAttemptCountYear: Int,
    @SerialName("mission")
    val mission: Mission,
    @SerialName("name")
    val name: String,
    @SerialName("net")
    val net: String,
    @SerialName("net_precision")
    val netPrecision: NetPrecision,
    @SerialName("orbital_launch_attempt_count")
    val orbitalLaunchAttemptCount: Int?,
    @SerialName("orbital_launch_attempt_count_year")
    val orbitalLaunchAttemptCountYear: Int,
    @SerialName("pad")
    val pad: Pad,
    @SerialName("pad_launch_attempt_count")
    val padLaunchAttemptCount: Int,
    @SerialName("pad_launch_attempt_count_year")
    val padLaunchAttemptCountYear: Int,
    @SerialName("probability")
    val probability: Int?,
    @SerialName("program")
    val program: List<Program>,
    @SerialName("response_mode")
    val responseMode: String,
    @SerialName("rocket")
    val rocket: Rocket,
    @SerialName("slug")
    val slug: String,
    @SerialName("status")
    val status: Status,
    @SerialName("url")
    val url: String,
    @SerialName("weather_concerns")
    val weatherConcerns: String?,
    @SerialName("webcast_live")
    val webcastLive: Boolean,
    @SerialName("window_end")
    val windowEnd: String,
    @SerialName("window_start")
    val windowStart: String
)