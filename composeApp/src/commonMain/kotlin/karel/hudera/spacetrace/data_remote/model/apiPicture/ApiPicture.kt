package karel.hudera.spacetrace.data_remote.model.apiPicture

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiPicture(
    @SerialName("copyright")
    val copyright: String,
    @SerialName("date")
    val date: String,
    @SerialName("explanation")
    val explanation: String,
    @SerialName("hdurl")
    val hdurl: String,
    @SerialName("media_type") // corrected
    val mediaType: String,
    @SerialName("service_version") // corrected
    val serviceVersion: String,
    @SerialName("title")
    val title: String,
    @SerialName("url")
    val url: String
)