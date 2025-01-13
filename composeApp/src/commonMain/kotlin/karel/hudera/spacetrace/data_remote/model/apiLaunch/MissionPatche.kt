package karel.hudera.spacetrace.data_remote.model.apiLaunch


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MissionPatche(
    @SerialName("agency")
    val agency: AgencyXX,
    @SerialName("id")
    val id: Int,
    @SerialName("image_url")
    val imageUrl: String,
    @SerialName("name")
    val name: String,
    @SerialName("priority")
    val priority: Int,
    @SerialName("response_mode")
    val responseMode: String
)