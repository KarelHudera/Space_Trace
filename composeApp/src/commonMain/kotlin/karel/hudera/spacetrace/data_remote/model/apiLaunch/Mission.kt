package karel.hudera.spacetrace.data_remote.model.apiLaunch


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Mission(
    @SerialName("agencies")
    val agencies: List<Agency>,
    @SerialName("description")
    val description: String,
    @SerialName("id")
    val id: Int,
    @SerialName("image")
    val image: String?,
    @SerialName("info_urls")
    val infoUrls: List<String?>,
    @SerialName("name")
    val name: String,
    @SerialName("orbit")
    val orbit: Orbit,
    @SerialName("type")
    val type: String,
    @SerialName("vid_urls")
    val vidUrls: List<String?>
)