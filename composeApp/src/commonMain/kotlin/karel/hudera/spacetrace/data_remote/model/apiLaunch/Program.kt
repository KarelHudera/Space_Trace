package karel.hudera.spacetrace.data_remote.model.apiLaunch


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Program(
    @SerialName("agencies")
    val agencies: List<AgencyXX>,
    @SerialName("description")
    val description: String,
    @SerialName("end_date")
    val endDate: String?,
    @SerialName("id")
    val id: Int,
    @SerialName("image")
    val image: Image,
    @SerialName("info_url")
    val infoUrl: String,
    @SerialName("mission_patches")
    val missionPatches: List<MissionPatche>,
    @SerialName("name")
    val name: String,
    @SerialName("response_mode")
    val responseMode: String,
    @SerialName("start_date")
    val startDate: String,
    @SerialName("type")
    val type: Type,
    @SerialName("url")
    val url: String,
    @SerialName("wiki_url")
    val wikiUrl: String
)