package karel.hudera.spacetrace.data_remote.model.apiLaunch


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LicenseX(
    @SerialName("id")
    val id: Int,
    @SerialName("link")
    val link: String?,
    @SerialName("name")
    val name: String,
    @SerialName("priority")
    val priority: Int
)