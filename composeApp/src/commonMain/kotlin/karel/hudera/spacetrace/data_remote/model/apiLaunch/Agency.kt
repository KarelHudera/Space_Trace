package karel.hudera.spacetrace.data_remote.model.apiLaunch


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Agency(
    @SerialName("abbrev")
    val abbrev: String,
    @SerialName("administrator")
    val administrator: String,
    @SerialName("attempted_landings")
    val attemptedLandings: Int,
    @SerialName("attempted_landings_payload")
    val attemptedLandingsPayload: Int,
    @SerialName("attempted_landings_spacecraft")
    val attemptedLandingsSpacecraft: Int,
    @SerialName("consecutive_successful_landings")
    val consecutiveSuccessfulLandings: Int,
    @SerialName("consecutive_successful_launches")
    val consecutiveSuccessfulLaunches: Int,
    @SerialName("country")
    val country: List<Country>,
    @SerialName("description")
    val description: String,
    @SerialName("failed_landings")
    val failedLandings: Int,
    @SerialName("failed_landings_payload")
    val failedLandingsPayload: Int,
    @SerialName("failed_landings_spacecraft")
    val failedLandingsSpacecraft: Int,
    @SerialName("failed_launches")
    val failedLaunches: Int,
    @SerialName("featured")
    val featured: Boolean,
    @SerialName("founding_year")
    val foundingYear: Int,
    @SerialName("id")
    val id: Int,
    @SerialName("image")
    val image: ImageX?,
    @SerialName("info_url")
    val infoUrl: String,
    @SerialName("launchers")
    val launchers: String,
    @SerialName("logo")
    val logo: Logo,
    @SerialName("name")
    val name: String,
    @SerialName("parent")
    val parent: String?,
    @SerialName("pending_launches")
    val pendingLaunches: Int,
    @SerialName("response_mode")
    val responseMode: String,
    @SerialName("social_logo")
    val socialLogo: SocialLogo,
    @SerialName("social_media_links")
    val socialMediaLinks: List<String?>,
    @SerialName("spacecraft")
    val spacecraft: String,
    @SerialName("successful_landings")
    val successfulLandings: Int,
    @SerialName("successful_landings_payload")
    val successfulLandingsPayload: Int,
    @SerialName("successful_landings_spacecraft")
    val successfulLandingsSpacecraft: Int,
    @SerialName("successful_launches")
    val successfulLaunches: Int,
    @SerialName("total_launch_count")
    val totalLaunchCount: Int,
    @SerialName("type")
    val type: Type,
    @SerialName("url")
    val url: String,
    @SerialName("wiki_url")
    val wikiUrl: String?
)