package karel.hudera.spacetrace.domain.model

import androidx.compose.runtime.Immutable

@Immutable
data class Launch(
    val id: String,
    val image: String,
    val name: String,
    val windowStart: String
)