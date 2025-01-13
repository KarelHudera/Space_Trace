package karel.hudera.spacetrace.data_remote.model.apiLaunch


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Image(
    @SerialName("credit")
    val credit: String?,
    @SerialName("id")
    val id: Int,
    @SerialName("image_url")
    val imageUrl: String,
    @SerialName("license")
    val license: License,
    @SerialName("name")
    val name: String,
    @SerialName("single_use")
    val singleUse: Boolean,
    @SerialName("thumbnail_url")
    val thumbnailUrl: String,
    @SerialName("variants")
    val variants: List<String?>
)