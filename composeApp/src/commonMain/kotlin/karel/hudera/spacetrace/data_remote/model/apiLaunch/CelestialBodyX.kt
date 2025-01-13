package karel.hudera.spacetrace.data_remote.model.apiLaunch


import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerializationException
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializable
data class CelestialBodyX(
    @SerialName("atmosphere")
    val atmosphere: Boolean,
    @SerialName("description")
    val description: String,
    @SerialName("diameter")
    @Serializable(with = DoubleScientificNotationSerializer::class)
    val diameter: Double,
    @SerialName("failed_landings")
    val failedLandings: Int,
    @SerialName("failed_launches")
    val failedLaunches: Int,
    @SerialName("gravity")
    val gravity: Double,
    @SerialName("id")
    val id: Int,
    @SerialName("image")
    val image: ImageXXXX,
    @SerialName("length_of_day")
    val lengthOfDay: String,
    @SerialName("mass")
    @Serializable(with = DoubleScientificNotationSerializer::class)
    val mass: Double,
    @SerialName("name")
    val name: String,
    @SerialName("response_mode")
    val responseMode: String,
    @SerialName("successful_landings")
    val successfulLandings: Int,
    @SerialName("successful_launches")
    val successfulLaunches: Int,
    @SerialName("total_attempted_landings")
    val totalAttemptedLandings: Int,
    @SerialName("total_attempted_launches")
    val totalAttemptedLaunches: Int,
    @SerialName("type")
    val type: Type,
    @SerialName("wiki_url")
    val wikiUrl: String
)

object DoubleScientificNotationSerializer : KSerializer<Double> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("Double", PrimitiveKind.DOUBLE)

    override fun serialize(encoder: Encoder, value: Double) {
        encoder.encodeDouble(value)
    }

    override fun deserialize(decoder: Decoder): Double {
        val value = decoder.decodeString()
        return value.toDoubleOrNull() ?: throw SerializationException("Invalid numeric format: $value")
    }
}