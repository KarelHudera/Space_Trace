package karel.hudera.spacetrace.data_remote.model.apiLaunch


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Configuration(
    @SerialName("families")
    val families: List<Family>,
    @SerialName("full_name")
    val fullName: String,
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("response_mode")
    val responseMode: String,
    @SerialName("url")
    val url: String,
    @SerialName("variant")
    val variant: String
)