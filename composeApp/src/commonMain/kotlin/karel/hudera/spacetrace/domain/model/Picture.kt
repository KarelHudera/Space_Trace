package karel.hudera.spacetrace.domain.model

import androidx.compose.runtime.Immutable

@Immutable
data class Picture(
    val copyright: String,
    val date: String,
    val explanation: String,
    val hdurl: String,
    val mediaType: String,
    val serviceVersion: String,
    val title: String,
    val url: String
)