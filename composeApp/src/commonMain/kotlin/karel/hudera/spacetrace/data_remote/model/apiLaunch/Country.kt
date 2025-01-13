package karel.hudera.spacetrace.data_remote.model.apiLaunch


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Country(
    @SerialName("alpha_2_code")
    val alpha2Code: String,
    @SerialName("alpha_3_code")
    val alpha3Code: String,
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("nationality_name")
    val nationalityName: String,
    @SerialName("nationality_name_composed")
    val nationalityNameComposed: String
)