package karel.hudera.spacetrace.data_remote.model.apiLaunch


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AgencyX(
    @SerialName("abbrev")
    val abbrev: String,
    @SerialName("administrator")
    val administrator: String,
    @SerialName("country")
    val country: List<Country>,
    @SerialName("description")
    val description: String,
    @SerialName("featured")
    val featured: Boolean,
    @SerialName("founding_year")
    val foundingYear: Int,
    @SerialName("id")
    val id: Int,
    @SerialName("image")
    val image: ImageX?,
    @SerialName("launchers")
    val launchers: String,
    @SerialName("logo")
    val logo: Logo,
    @SerialName("name")
    val name: String,
    @SerialName("parent")
    val parent: String?,
    @SerialName("response_mode")
    val responseMode: String,
    @SerialName("social_logo")
    val socialLogo: SocialLogo,
    @SerialName("spacecraft")
    val spacecraft: String,
    @SerialName("type")
    val type: Type,
    @SerialName("url")
    val url: String
)